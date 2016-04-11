/*
 * 本题的关键在于不仅仅是单纯的无向带权图的最短路径问题
 * 本题还存在多条最短路径，并且利用其它约束条件选择其中一条的问题
 * 该问题的解决方式是对于通用的Dijkstra算法进行修改，在relax节点的过程中加入额外的判断
 * 如果直接距离大于间接距离，则relax该节点
 * 如果间接距离等于直接距离，说明出现了多条最短路径，在这种情况下对计数器加1，并且判断是否需要更新约束条件（相当于一个多重Dijkstra算法）
 * 该问题非常有学习价值！
 */

import java.util.Scanner;


public class PAT1003 {

    private int E;
    private int V;
    private int st;
    private int end;
    private int[][] map;
    private int[] rescue;
    private int[] distTo;
    private boolean[] marked;
    private int[] edgeTo;
    private int mind;
    
    private int[] roadnum;
    private int[] rescuenum;
    
    public PAT1003()
    {
        Scanner in = new Scanner(System.in);
        V = in.nextInt();
        E = in.nextInt();
        st = in.nextInt();
        end = in.nextInt();
        
        rescue = new int[V];
        map = new int[V][V];
        edgeTo = new int[V];
        for (int i=0; i<V; i++)
        {
            rescue[i] = in.nextInt();
        }
        
        for(int i=0; i < V; i++)
            for(int j=0; j < V; j++)
                map[i][j] = i==j? 0 : 1000;
        
        for (int i = 0; i<E; i++)
        {
            int m,n;
            m = in.nextInt();
            n = in.nextInt();
            int road = in.nextInt();
            map[m][n] = road;
            map[n][m] = road;
        }
        
        in.close();
        
    }
    
    public void Dijkstra()
    {
        distTo = new int[V];
        marked = new boolean[V];
        roadnum = new int[V];
        rescuenum = new int[V];
        
        roadnum[st] = 1;
        rescuenum[st] = rescue[st];
        
        marked[st] = false;
        for(int i = 0; i<V; i++)
        {
            distTo[i] = map[st][i];
        }
        
        for(int count = 0; count < V; count++)
        {
            double mindist = 1000;
            int k = -1;
            for(int i = 0; i < V; i++)
            {
                if(!marked[i] && distTo[i] < mindist)
                {
                    mindist = distTo[i];
                    k = i;
                }
            }
            
            marked[k] = true;
            
            for(int i = 0; i < V; i++)
            {
                if(!marked[i] && distTo[i] > distTo[k] + map[k][i])
                {
                    distTo[i] = distTo[k] +map[k][i];
                    edgeTo[i] = k;
                    roadnum[i] = roadnum[k];
                    rescuenum[i] = rescuenum[k] + rescue[i];
                }
                else if(!marked[i] && distTo[i] == distTo[k] + map[k][i])
                {
                    roadnum[i] += roadnum[k];
                    rescuenum[i] = (rescuenum[i] > rescuenum[k] + rescue[i]) 
                            ? rescuenum[i] : rescuenum[k] + rescue[i];
                }
            }
        }
        
        mind = distTo[end];
        //System.out.println("dist is "+ mind);
        System.out.println(roadnum[end]+" "+rescuenum[end]);
    }

    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PAT1003 pat = new PAT1003();
        pat.Dijkstra();
    }

}

