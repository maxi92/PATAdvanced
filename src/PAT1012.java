/*
 * �����ⲻ�ѣ���������������Ҫע��һ��
 * ��һ�����ڲ���Ҫ��Ԫ�أ������������ж��Ƿ���Ҫ�����ý����������㣬���Խ�ʡʱ��
 * �ڶ���Java��Ч�ʷǳ�֮�ͣ��ر���������IO�ϣ����Զ����д����������Ŀ��������ʹ��Scanner�࣬ʹ��BufferedReader���úܶ�
 * ��ȻBufferedReader��ʹ�ò���ô���㣬�����ܽ�Լʱ��
 * ��γ�ʱ������Ϊʹ����Scanner��
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

        
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        M = in.nextInt();
        list  = new grade[N];
        
        for(int i = 0; i < N; i++)
        {            
            int id = in.nextInt();
            double C = in.nextInt();
            double M = in.nextInt();
            double E = in.nextInt();
            
            list[i] = new grade(id, C, M, E);
        }
        
        int[] query = new int[M];
        for(int i = 0; i < M; i++)
            query[i] = in.nextInt();
        
        for(int i = 0; i < M; i++)
        {
            
            int id = query[i];
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
        in.close();
    }
    
    public static void main(String[] args) throws Exception {
        // TODO Auto-generated method stub
        PAT1012 pat = new PAT1012();
        pat.cal();
    }

}
