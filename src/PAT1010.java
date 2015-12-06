/*
 * �����ⲻ���������֣��м���������Ҫע��
 * ��һ��N2��������Ƶ�������N2����λ��������������+1��������N1+1����Ϊ������Ʊ�������󣬼�ʹ��N2=1��N2Ҳ��N1�����ǲ����ܵģ�
 * �ڶ���ע��N2�Ľ������޲�����37���������Ŀ�в����׶�����
 * ������ע��ʹ�ö�����������Լʱ��
 * ���ģ���������һ��standard1 == convert(N2.charAt(0)) && N2.length() == 1���ж���䣬�Ҳ�֪��ΪʲôҪ����һ��
 * �����������OJ����һ�����������ˣ��������һ������
 * ���Ҫע�����������ѭ��������low <= high������ȡ��
 */

import java.util.Scanner;


public class PAT1010 {

    private String N1;
    private String N2;
    private int tag;
    private int radix;
    public PAT1010()
    {
       Scanner in = new Scanner(System.in);
       String[] line = in.nextLine().split(" ");
       N1 = line[0];
       N2 = line[1];
       tag = Integer.parseInt(line[2]);
       radix = Integer.parseInt(line[3]);
       
       compare();
    }
    
    private void compare()
    {
        long standard1 = 0;
        long standard2 = 0;
        if(tag == 1)
        {
            standard1 = radix(N1, radix);

            int maxdigit = 0;
            for(int i = 0; i < N2.length(); i++)
            {
                char tmp = N2.charAt(i);
                int digit = convert(tmp);
                if (digit > maxdigit)
                {
                    maxdigit = digit;
                }
            }
            
            if(standard1 == convert(N2.charAt(0)) && N2.length() == 1)
            {
                System.out.print(maxdigit+1);
                return;
            }
            
            long low = maxdigit + 1;
            long high = standard1 + 1;
            long mid = (low + high)/2;
            
            while(low <= high)
            {
                mid = (low + high)/2;
                standard2 = radix(N2, mid);
                if(standard2 == standard1)
                {
                    System.out.print(mid+"");
                    return;
                }
                if(standard2 > standard1 || standard2 == -1)
                    high = mid - 1;
                if(standard2 < standard1)
                    low = mid + 1;
            }
            
            System.out.print("Impossible");

        }
        else if(tag == 2)
        {

            standard1 = radix(N2, radix); 
            
            int maxdigit = 0;
            for(int i = 0; i < N1.length(); i++)
            {
                char tmp = N1.charAt(i);
                int digit = convert(tmp);
                if (digit > maxdigit)
                {
                    maxdigit = digit;
                }
            }
            
            if(standard1 == convert(N1.charAt(0)) && N1.length() == 1)
            {
                System.out.print(maxdigit+1);
                return;
            }
            
            long low = maxdigit;
            long high = standard1 + 1;
            long mid = (low + high)/2;
            
            while(low <= high)
            {
                mid = (low + high)/2;
                standard2 = radix(N1, mid);
                if(standard2 == standard1)
                {
                    System.out.print(mid+"");
                    return;
                }
                if(standard2 > standard1 || standard2 == -1)
                    high = mid - 1;
                if(standard2 < standard1)
                    low = mid + 1;
            }
            
            System.out.print("Impossible");
        }

    }
    
    private int convert(char digit)
    {
        if('0' <= digit && digit <= '9')
        {
            return Integer.parseInt(digit+"");
        }
        else
        {
            return digit - 'a' + 10;
        }
    }
    
    private long radix(String N, long radix)
    {
        long standard = 0;
        for(int i = 0; i < N.length(); i++)
        {
            char tmp = N.charAt(i);
            int digit = convert(tmp);
            standard += digit * Math.pow(radix, N.length() - i - 1);
        }
        if(standard < 0) return -1;
        return standard;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        PAT1010 pat = new PAT1010();
    }

}
