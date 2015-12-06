/*
 * 本问题不难，但是有两个点需要注意一下
 * 第一，对于不需要的元素（根据输入来判断是否需要）不用进行排名计算，可以节省时间
 * 第二，Java的效率非常之低，特别是体现在IO上，所以对于有大量输入的题目尽量避免使用Scanner类，使用BufferedReader类会好很多
 * 虽然BufferedReader类使用不那么方便，但是能节约时间
 * 这次超时就是因为使用了Scanner类
 */

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;



public class PAT1012 {

    private class grade{
        private int id;
        private double C;
        private double M;
        private double E;
        private double A;
        
        public grade(int id, double C, double M, double E)
        {
            this.id = id;
            this.C = C;
            this.M = M;
            this.E = E;
            this.A = (C + M + E)/3;
        }
    }
    
    private int N;
    private int M;
    private grade[] list;
    
    public void cal() throws Exception
    {
        /*BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String tmp[] = str.split(" ");
        N = Integer.parseInt(tmp[0]);
        M = Integer.parseInt(tmp[1]);*/
        
        Scanner in = new Scanner(new BufferedInputStream(System.in));
        N = in.nextInt();
        M = in.nextInt();
        list  = new grade[N];
        
        for(int i = 0; i < N; i++)
        {
            /*str = br.readLine();
            tmp = str.split(" ");
            int id = Integer.parseInt(tmp[0]);
            double C = Integer.parseInt(tmp[1]);
            double M = Integer.parseInt(tmp[2]);
            double E = Integer.parseInt(tmp[3]);*/
            
            int id = in.nextInt();
            double C = in.nextInt();
            double M = in.nextInt();
            double E = in.nextInt();
            
            list[i] = new grade(id, C, M, E);
        }
        
        for(int i = 0; i < M; i++)
        {
            /*str = br.readLine();
            int id = Integer.parseInt(str);*/
            
            int id = in.nextInt();
            int k = -1;
            for(int j = 0; j < N; j++)
            {
                if(id == list[j].id)
                {
                    k = j;
                    break;
                }
            }
            if(k == -1)
            {
                System.out.println("N/A");
                continue;
            }
            int rankC = 1;
            int rankM = 1;
            int rankE = 1;
            int rankA = 1;
            
            for(int j = 0; j < N; j++)
            {
                if(k == j) continue;
                
                if(list[k].C < list[j].C)
                    rankC++;
                if(list[k].M < list[j].M)
                    rankM++;
                if(list[k].E < list[j].E)
                    rankE++;
                if(list[k].A < list[j].A)
                    rankA++;
            }
            
            int rank = rankA;
            String best = "A";
            
            if(rankC < rank)
            {
                rank = rankC;
                best = "C";
            }
            
            if(rankM < rank)
            {
                rank = rankM;
                best = "M";
            }
            
            if(rankE < rank)
            {
                rank = rankE;
                best = "E";
            }
            
            System.out.println(""+rank+" "+best);
        }

    }
    
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        PAT1012 pat = new PAT1012();
        pat.cal();
    }

}
