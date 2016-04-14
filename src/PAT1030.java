/*
 * 这道题目主要是Dijkstra算法的应用，不难
 * 然而在PAT网站上能过，在牛客网上就不能过，也不知道是为啥
 * 而且听说两点之间不止一条路，这也有点坑
 */
import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class PAT1030 {

    public TreeSet<Integer> al;
    public int[][] graph;
    public int[][] cost;
    public int V,E,st,end;
    public int[] distTo;
    public int[] edgeTo;
    public boolean[] visited;
    public int[] costTo;
    
    public void run()
    {
        init();
        Dijkstra();
        print();
    }
    
    public void print()
    {
        Stack<Integer> stack = new Stack<Integer>();
        int i = end;
        while(edgeTo[i] != -1)
        {
            stack.push(i);
            i = edgeTo[i];
        }
        stack.push(st);
        
        while(!stack.isEmpty())
        {
            System.out.print(stack.pop()+" ");
        }
        
        System.out.print(distTo[end]+" "+costTo[end]);
    }
    
    public void Dijkstra()
    {
        for(int i = 0; i < V; i++)
        {
            int min = (int) Double.POSITIVE_INFINITY;
            int index = 0;
            
            
            for(int j = 0; j < V; j++)
            {
                if(!visited[j])
                {
                    if(min > distTo[j])
                    {
                        min = distTo[j];
                        index = j;
                    }
                }
            }
            visited[index] = true;
            
            for(int j = 0; j < V; j++)
            {
                if(!visited[j] && graph[index][j]!=-1)
                {
                    if(distTo[j] > graph[index][j] + distTo[index])
                    {
                        distTo[j] = graph[index][j] + distTo[index];
                        edgeTo[j] = index;
                        costTo[j] = cost[index][j] + costTo[index];
                    }
                    else if(distTo[j] == graph[index][j] + distTo[index])
                    {
                        if(costTo[j] > cost[index][j] + costTo[index])
                        {
                            distTo[j] = graph[index][j] + distTo[index];
                            edgeTo[j] = index;
                            costTo[j] = cost[index][j] + costTo[index];
                        }
                    }
                }
            }
        }
    }
    
    public void init()
    {
        Scanner in = new Scanner(System.in);
        V = in.nextInt();
        E = in.nextInt();
        st = in.nextInt();
        end = in.nextInt();
        graph = new int[V][V];
        cost = new int[V][V];
        distTo = new int[V];
        edgeTo = new int[V];
        visited = new boolean[V];
        costTo  = new int[V];
        
        for(int i =0; i < V; i++)
            for(int j=0; j < V; j++)
            {
                graph[i][j] = cost[i][j] = -1;
            }
        
        for(int j = 0; j < E; j++)
        {
            int from,to,dis,co;
            from = in.nextInt();
            to = in.nextInt();
            dis = in.nextInt();
            co = in.nextInt();
            if(graph[from][to] == -1 ||(graph[from][to]!=-1 && cost[from][to] > co))
            {
                graph[from][to] = graph[to][from] = dis;
                cost[from][to] = cost[to][from] = co;
            }
        }
        in.close();
        
        for(int i = 0; i < V; i++)
        {
            distTo[i] = costTo[i] = (int) Double.POSITIVE_INFINITY;
            edgeTo[i] = -1;
            visited[i] = false;
        }
        distTo[st] = 0;
        costTo[st] = 0;        
        edgeTo[st] = -1;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PAT1030 pat = new PAT1030();
        pat.run();
    }
    
}
