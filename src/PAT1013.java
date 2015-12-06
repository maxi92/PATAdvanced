import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.NoSuchElementException;

public class PAT1013 {

    private static int N;
    private static int M;
    private static int K;
    private static ArrayList<Integer>[] map;
    private static boolean[] visit;
    private static int count = 0;
    
    
    private static void cal(int m)
    {
        count = 0;
        for(int i = 0; i < N; i++)
        {
            if(!visit[i])
            {
                count++;
                dfs(i,m);
            }
        }
    }
   
    private static void dfs(int start, int check)
    {
        if(start == check) return;
        visit[start]  = true;
        
        for(int w : map[start])
        {
            if(!visit[w] && w != check)
                dfs(w, check);
        }
    }
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub        
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String tmp[] = str.split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);
        K = Integer.parseInt(tmp[2]);*/
        
        Scanner1 in = new Scanner1(System.in);
        N = in.nextInt();
        M = in.nextInt();
        K = in.nextInt();
        
        map = (ArrayList<Integer>[]) new ArrayList[N];
        visit = new boolean[N];
        
        for(int i = 0; i < N; i++)
        {
            map[i] = new ArrayList<Integer>();
        }
        
        for(int i = 0; i < M; i++)
        {
            /*str = br.readLine();
            tmp = str.split(" ");
            int m = Integer.parseInt(tmp[0]) - 1;
            int n = Integer.parseInt(tmp[1]) - 1;*/
            int m = in.nextInt() - 1;
            int n = in.nextInt() - 1 ;
            map[m].add(n);
            map[n].add(m);
        }
        
        /*str = br.readLine();
        tmp = str.split(" ");*/
        
        for(int i = 0; i < K; i++)
        {
            //int m = Integer.parseInt(tmp[i]) - 1;
            int m = in.nextInt() - 1;
            cal(m);
            System.out.println(count-2);
            visit = new boolean[N];
        }
    }
}


class Scanner1 {
    
    public Scanner1(InputStream is) {
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