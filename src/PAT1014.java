import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Scanner;


public class PAT1014 {

    private static Window[] window;
    private static customer[] cust;
    private static int time[];
    
    private static int N;
    private static int M;
    private static int K;
    private static int Q;
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //Scanner2 in = new Scanner2(System.in);
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        K = in.nextInt();
        Q = in.nextInt();
        
        window = new Window[N];
        cust = new customer[K];
        time = new int[K];
        
        for(int i = 0; i < K; i++)
        {
            time[i] = in.nextInt();
            cust[i] = new customer();
        }
        
        for(int i = 0; i < N; i++)
        {
            window[i] = new Window();
        }
        
        int q, i;
        for(i = 0; i < M*N && i < K; i++)
        {
            q = i % N;
            window[q].queue.add(i);
            cust[i].st = window[q].et;
            cust[i].et = cust[i].st + time[i];
            window[q].et += time[i];
        }
        
        for(;i < K; i++)
        {
            int mintime = 10000000;
            int pos = 0;
            for(int j = 0; j < N; j++)
            {
                int tmp = window[j].queue.element();
                if(cust[tmp].et < mintime)
                {
                    mintime = cust[tmp].et;
                    pos = j;
                }
            }
            
            
            cust[i].st = window[pos].et;
            cust[i].et = cust[i].st + time[i];
            window[pos].et += time[i];
            window[pos].queue.remove();
            window[pos].queue.add(i);
        }
        
        
        for(i = 0; i < Q; i++)
        {
            int query = in.nextInt() - 1;
            int hour;
            int minute;

            hour = cust[query].et / 60;
            minute = cust[query].et % 60;
            
           int sttime = cust[query].st;
            
            if(hour == 9 && minute == 0)
            {
                System.out.println("17:00");
                continue;
            }
            else if(sttime >= 540)
            {
                System.out.println("Sorry");
                continue;
            }
            
            hour = hour + 8;
            String shour = hour+"";
            String sminute = minute+"";
            if(hour < 10)
            {
                shour = "0" + hour;
            }
            
            if(minute < 10)
            {
                sminute = "0" + minute;
            }
            
            System.out.println(shour+":"+sminute);
        }
        in.close();
    }

}

class Window{
    public int et;
    Queue<Integer> queue;
    
    public Window()
    {
        queue = new LinkedList<Integer>();
    }
}

class customer{
    public int st;
    public int et;
}

class Scanner2 {
    
    public Scanner2(InputStream is) {
        this.is = new BufferedInputStream(is);
        poll();
    }

    public void close() {
        try {
            is.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int nextInt() {
        int n = 0;

        toInt();

        while (isDigit(peek())) {
            n = n * 10 + peek() - '0';
            poll();
        }

        return n;

    }

    private final BufferedInputStream is;

    private int next = -2;

    private int peek() {
        return next;
    }

    private void poll() {
        try {
            next = is.read();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private void toInt() {
        while (peek() != -1 && !isDigit(peek())) {
            poll();
        }
        if (peek() == -1) {
            throw new NoSuchElementException();
        }
    }

    private boolean isDigit(int i) {
        return '0' <= i && i <= '9';
    }
}