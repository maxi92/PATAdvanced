/*
 * 这个问题的解答我是借用了图的思想
 * 利用BFS从根结点开始扫描整个树
 * 因为树的特殊性质，所以一个节点的下一个节点其深度必然比该节点大1，所以用一个数组distTo就可以记录所有的节点深度
 * 再用一个HashSet数组来记录每一个节点的子节点数量
 */

import java.util.HashSet;
import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.LinkedBlockingQueue;


public class PAT1004 {

    private int N;
    private int M;
    private HashSet<Integer>[] tree;
    private int distTo[];
    private int nochildren[];
    
    public PAT1004()
    {
        Scanner in = new Scanner(System.in);
        this.N = in.nextInt();
        this.M = in.nextInt();
        tree = (HashSet<Integer>[]) new HashSet[N];
        distTo = new int[N];
        nochildren = new int[N];
        
        
        for(int i = 0; i < N; i++)
        {
            tree[i] = new HashSet<Integer>();
            nochildren[i] = 0;
        }
     
        for(int i = 0; i < M; i++)
        {
            int id = in.nextInt() - 1;
            int K = in.nextInt();
            for (int j = 0; j < K; j++)
            {
                int index = in.nextInt() - 1;
                tree[id].add(index);
            }
        }
        in.close();
    }
    
    public void nochild()
    {
        Queue<Integer> queue = new LinkedBlockingQueue<Integer>();
        queue.add(0);
        distTo[0] = 0;
        while(!queue.isEmpty())
        {
            int index = queue.remove();
            if(tree[index].size() == 0) 
            {
                nochildren[distTo[index]]++;
            }
            
            for(int w : tree[index])
            {
                distTo[w] = distTo[index] + 1;
                queue.add(w);
            }
        }
        
        int maxdist = 0;
        for(int i = 0; i < N; i++)
        {
            if(distTo[i] > maxdist)
                maxdist = distTo[i];
        }
        
        for(int i = 0; i <= maxdist; i++)
        {
            System.out.print(""+nochildren[i]);
            if(i != maxdist)
                System.out.print(" ");
        }
    }
    
    public static void main(String[] args){
        PAT1004 pat = new PAT1004();
        pat.nochild();
    }
}
