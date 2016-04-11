import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class PAT1018 {
    
    public static int[][] map;
    public static int[] bike;
    public static int C, N, P, M;
    public static boolean[] visited;
    public static int[] distTo;
    public static int[] edgeTo;
    public static boolean[] marked;
    public static int[] roadnum;
    public static int mindist;
    public static int road;
    public static int count;
    public static int totalNeed;
    public static int collect;
    public static int send;
    public static int[] backupEdgeTo;
    
    
    public static void Dijkstra()
    {
        visited[0] = true;
        roadnum[0] = 1;
        for(int i = 0; i < N+1; i++)
        {
            int mindist = 100000;
            int k = 0;
            for(int j = 0; j < N+1; j++)
            {
                if(!visited[j] && distTo[j] < mindist)
                {
                    k = j;
                    mindist = distTo[j];
                }
            }
            
            visited[k] = true;
            for(int j = 0; j < N+1; j++)
            {
                if(!visited[j] && distTo[j] > distTo[k] + map[k][j])
                    {
                        distTo[j] = distTo[k] + map[k][j];
                        roadnum[i] = roadnum[k];
                    }
                else if(!visited[j] && distTo[j] == distTo[k] + map[k][j])
                    roadnum[i] += roadnum[k];
            }
        }
        
        mindist = distTo[P];
        road = roadnum[P];
    }
    
    public static void dfs(int s, int len)
    {
        if(len > distTo[s] || count == road) return;
        
        if(len == mindist && s == P)
        {
            count++;
            cal();
        }
        marked[s] = true;
        
        for(int i = 0; i < N+1; i++)
        {
            if(i == s) continue;
            if(!marked[i] && map[i][s] != 100000)
            {
                edgeTo[i] = s;
                dfs(i, len + map[i][s]);
                marked[i] = false;
                edgeTo[i] = -1;
            }
        }
    }
    
    private static void cal()
    {
        int p = P;
        int sum = 0;
        int need;
        while(p != 0)
        {
            need = C/2 - bike[p];
            sum += need;
        }
        
        if(count == 1)
        {
            if(sum < 0) collect = -sum;
            else if(sum > 0) send = sum;
            backupEdgeTo = edgeTo.clone();
        }
        
        if(Math.abs(sum) < totalNeed)
        {
            if(sum < 0) collect = -sum;
            else if(sum > 0) send = sum;
            backupEdgeTo = edgeTo.clone();
        }
        
        
    }
    
    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub
        
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String str = br.readLine();
        String[] tmp = str.split(" ");
        C = Integer.parseInt(tmp[0]);
        N = Integer.parseInt(tmp[1]);
        P = Integer.parseInt(tmp[2]);
        M = Integer.parseInt(tmp[3]);
        
        bike = new int[N+1];
        map = new int[N+1][N+1];
        visited = new boolean[N+1];
        distTo = new int[N+1];
        marked = new boolean[N+1];
        edgeTo = new int[N+1];
        roadnum = new int[N+1];
        backupEdgeTo = new int[N+1];
        
        str = br.readLine();
        tmp = str.split(" ");
        bike[0] = -1;
        for(int i = 1; i < N+1; i++)
        {
            bike[i] = Integer.parseInt(tmp[i-1]);
            edgeTo[i] = -1;
        }
        
        for(int i = 0; i < N + 1; i++)
        {
            for(int j = 0; j < N+1; j++)
            {
                map[i][j] = (i == j)? 0 : 100000;
            }
        }
        
        for(int i = 0; i < N+1; i++)
        {
            distTo[i] = map[0][i];
        }
        
        for(int i = 0; i < M; i++)
        {
            str = br.readLine();
            tmp = str.split(" ");
            int v, w, dis;
            v = Integer.parseInt(tmp[0]);
            w = Integer.parseInt(tmp[1]);
            dis = Integer.parseInt(tmp[2]);
            map[v][w] = dis;
            map[w][v]  = dis;
        }
        
        Dijkstra();
        dfs(0, 0);
        
        System.out.print(send +" ");
        
        Stack<Integer> stack = new Stack<Integer>();
        
        int p = P;
        while(p != 0)
        {
            stack.push(p);
            p = backupEdgeTo[p];
        }
        
        System.out.print(0);
        while(!stack.isEmpty())
        {
            System.out.print("->"+stack.pop());
        }
        
        System.out.print(" "+ collect);
        
    }
    

}
