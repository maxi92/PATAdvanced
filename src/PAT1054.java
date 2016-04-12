/*
 * 该程序思路来源于腾讯笔试的微信红包那道题
 * 因为一个颜色数量占据了一半还多，所以说明该颜色的数量减去其它所有颜色的数量应该大于零
 * 还有一个问题就是，如果总的像素点数据过多，如果用一个数组存储所有的像素点颜色，会造成内存浪费
 * 所以就只存一列（或者一行）的数据，读完就丢掉（应该可以读一个像素丢一个的，那样应该更省内存）
 * 具体思路直接看代码好了
 * 这一类题目都是这种思路
 */
import java.util.Scanner;

public class PAT1054 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int M,N;
        Scanner in = new Scanner(System.in);
        M = in.nextInt();
        N = in.nextInt();
        
        int[] col = new int[M];
        int target = -1;
        int time = 1;
        
        for(int i=0; i < N; i++)
        {
            for(int j=0; j < M; j++)
            {
                col[j] = in.nextInt();
            }
            
            if(i == 0) target = col[0];
            
            for(int k=1; k < M; k++)
            {
                if(col[k] == target) time++;
                else time--;
                if(time == 0)
                {
                    time = 1;
                    target = col[k];
                }
            }
            col = new int[M];
        }
        in.close();
        System.out.print(target);
    }

}
