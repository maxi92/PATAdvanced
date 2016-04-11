import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class PAT1017 {
    
    private class customer implements Comparable<customer>{
        public int hour;
        public int minute;
        public int second;
        public int protime;
        public int sttime;
        public int endtime;
        public int time;
        
        customer(int hour, int minute, int second, int protime)
        {
            this.hour = hour;
            this.minute = minute;
            this.second = second;
            this.protime = protime;
            this.time = hour * 3600 + minute * 60 + second;
        }
        
        public int compareTo(customer c)
        {
            if(this.hour > c.hour) return 1;
            else if(this.hour < c.hour) return -1;
            else if(this.minute > c.minute) return 1;
            else if(this.minute < c.minute) return -1;
            else if(this.second > c.second) return 1;
            else if(this.second < c.second) return -1;
            else return 0;
        }
    }
    
    private int N;
    private int K;
    private customer[] cus;
    private customer[] windows;
    private int waittime = 0;
    private double averytime;
    
    public PAT1017() throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] tmp = str.split(" ");
        N = Integer.parseInt(tmp[0]);
        K = Integer.parseInt(tmp[1]);
        cus = new customer[N];
        windows = new customer[K];
        String[] tmp2;
        
        for(int i = 0; i < N; i++)
        {
            str = br.readLine();
            tmp = str.split(" ");
            tmp2 = tmp[0].split(":");
            cus[i] = new customer(Integer.parseInt(tmp2[0]), Integer.parseInt(tmp2[1]), 
                    Integer.parseInt(tmp2[2]), Integer.parseInt(tmp[1]));
        }
        
        Arrays.sort(cus);
        
        int i;
        for(i = 0; i < K; i++)
        {
            if(cus[i].hour < 8) cus[i].sttime = 28800;
            else if(cus[i].hour < 17 || 
                    cus[i].time == 61200) cus[i].sttime = cus[i].time;
            else
            {
                cus[i].sttime = -1;
                N = i;
                break;
            }
            cus[i].endtime = cus[i].sttime + cus[i].protime * 60;
            windows[i] = cus[i];
        }
        
        for(; i < N; i++)
        {   
            int out = 0;
            int min = 100000;
            
            if(cus[i].time > 61200)
            {
                cus[i].sttime = -1;
                N = i;
                break;
            }
            
            for(int k = 0; k < K; k++)
            {
                if(min > windows[k].endtime)
                {
                    min = windows[k].endtime;
                    out = k;
                }
            }
            
            if(windows[out].endtime <= cus[i].time)
            {
                cus[i].sttime = cus[i].time;
                cus[i].endtime = cus[i].sttime + cus[i].protime * 60;
                windows[out] = cus[i];
            }
            else 
            {
                cus[i].sttime = windows[out].endtime;
                cus[i].endtime = cus[i].sttime + cus[i].protime * 60;
                windows[out] = cus[i];
            }
        }
        
        for(i = 0; i < N; i++)
        {
            waittime += cus[i].sttime - cus[i].time;
        }
        
        averytime = waittime / N;
        averytime = averytime / 60;
        
        System.out.printf("%.1f",averytime);
    }
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        PAT1017 pat = new PAT1017();
        
    }

}
