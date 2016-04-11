/*
 * �����Է��ӣ����������ݽṹ��ѡ��
 * �ʼ��ѡ��������û�����Ϊ�������洢ûһ���û���ͨ����Ϣ
 * �����������ַ�ʽ�ǳ����ӣ���ʹ����java�Դ���HashMapҲ��Ҫ���ؽṹǶ�ף����ҹ���Ч��Ҳ�ܵ�
 * �������˱��˵�C++����ŷ��ֿ�������sort����������
 * ��customers��̳�Comparable�ӿڣ�����һ��compareTo����
 * �Ȱ�����������������ͬ������ʱ������
 * ������һ�����ݽӿ��д洢�������˵���Ϣ
 * Ȼ���ٵ������е���Ϣ��ȡ����Ч����Ϣ���д���
 * 
 * ���о��ǣ�������õ�ʱ�򣬿��Դ��³�Ϊ������on-line���ܷ��ú�off-line���ܷ��ã�Ȼ���������ʵ�ʷ��ã����ַ��������˸�������Ŀ��ǣ��ǳ����
 * 
 * ��������Լ�����Ҫ������java���ָ��ӵ����ݽṹ�������������Դ�˷ѣ�ͬʱҲ������ס�Լ���˼·������PAT���ԣ�������C++�����ݽṹ��������Ŀ
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;


public class PAT1016 {
    
    private static int[] toll = new int[24];
    private static int N;
    private static ArrayList<customers> record = new ArrayList<customers>();
    private static ArrayList<customers> formatrec = new ArrayList<customers>();
    
    private static void getValidrec()
    {
        boolean haveonline = false;
        String currentname = "";
        for(customers cus : record)
        {
            if(!haveonline && cus.state)
            {
                formatrec.add(cus);
                currentname = cus.name;
                haveonline = true;
            }
            else if(haveonline && cus.state)
            {
                formatrec.remove(formatrec.size()-1);
                formatrec.add(cus);
                haveonline = true;
                currentname = cus.name;
            }
            else if(haveonline && !cus.state && cus.name.equals(currentname))
            {
                haveonline = false;
                formatrec.add(cus);
            }
        }
        
        if(formatrec.get(formatrec.size()-1).state)
            formatrec.remove(formatrec.size()-1);
    }
    
    private static void getResult()
    {
        String currentname = "";
        double totalcost = 0;
        customers prev = null;
        
        for(customers cus : formatrec)
        {
            if(!currentname.equals(cus.name))
            {
                if(currentname.equals(""))
                {
                    System.out.println(cus.name+" "+cus.smonth);
                    currentname = cus.name;
                }
                else
                {
                    System.out.printf("Total amount: $%.2f\n",totalcost);
                    System.out.println(cus.name+" "+ cus.smonth);
                    totalcost = 0;
                    currentname = cus.name;
                }
            }

            if(cus.state)
            {
                System.out.print(cus);
                prev = cus;
            }
            if(!cus.state)
            {
                System.out.print(" " + cus + " ");
                System.out.print(last(prev, cus) + " ");
                double fee = cal(prev, cus);
                System.out.printf("$%.2f\n", fee);
                totalcost += fee;
            }
        }
        System.out.printf("Total amount: $%.2f\n",totalcost);
    }
    
    private static double cal(customers st, customers end)
    {
        return (chargeByTime(end) - chargeByTime(st))/100;
    }
    
    private static double chargeByTime(customers cus)
    {
        int totaltime = cus.minute + cus.hour *60 + cus.day * 60 * 24;
        int hours = totaltime / 60;
        int minute = totaltime % 60;
        int money  = 0;
        int i = 0;
        for(i = 0; i < hours; i++)
            money += toll[i%24]*60;
        money += toll[i%24] * minute;
        return money;
    }
    
    private static int last(customers st, customers end)
    {
        int day = end.day - st.day;
        int hour = end.hour - st.hour;
        int minute = end.minute - st.minute;
        int last = day * 60 * 24 + hour * 60 + minute;
        return last;
    }
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] tmp = str.split(" ");
        
        for(int i = 0; i < 24; i++)
        {
            toll[i] = Integer.parseInt(tmp[i]);
        }
        
        str = br.readLine();
        N = Integer.parseInt(str);
        
        for(int i = 0; i < N; i++)
        {
            str = br.readLine();
            tmp = str.split(" ");
            record.add(new customers(tmp[0], tmp[1], tmp[2]));
        }
        
        Collections.sort(record);
        
        getValidrec();
        
        getResult();
    }

}

class customers implements Comparable<customers>{
    
    public String name;
    public int month;
    public int day;
    public int hour;
    public int minute;
    public boolean state;
    public String smonth;
    
    public customers(String name, String time, String state)
    {
        this.name = name;
        String[] tmp = time.split(":");
        this.month = Integer.parseInt(tmp[0]);
        this.day = Integer.parseInt(tmp[1]);
        this.hour = Integer.parseInt(tmp[2]);
        this.minute = Integer.parseInt(tmp[3]);
        this.state = (state.equals("on-line"))? true : false;
        if(month < 10)
            smonth = "0" + month;
        else smonth = month + "";
    }
    
    public int compareTo(customers other)
    {
        if(name.compareTo(other.name) > 0)
            return 1;
        else if(name.compareTo(other.name) < 0)
            return -1;
        else if(day > other.day)
            return 1;
        else if(day < other.day)
            return -1;
        else if(hour > other.hour)
            return 1;
        else if(hour < other.hour)
            return -1;
        else if(minute > other.minute)
            return 1;
        else if(minute < other.minute)
            return -1;
        else return 0;
    }
    
    public String toString()
    {
        String sday = day + "";
        String shour = hour + "";
        String smin = minute + "";
        if(day < 10) sday = "0"+sday;
        if(hour < 10) shour = "0"+shour;
        if(minute < 10) smin = "0" + smin;
        return (sday+":"+shour+":"+smin);
    }
}
