/*
 * 此题是贪心算法的一个实际应用
 * 求两个数列相互乘积的最大值
 * 就是从两头逼近中间，绝对值最大的负数两两相乘，最大的整数两两相乘
 * 注意边界条件判断放在正负判断的前面，避免因为编译器判断条件的先后问题而越界
 */
import java.util.Arrays;
import java.util.Scanner;

public class PAT1037{

    public static long[] a,b;
    public static int M, N;
    public static long res;
    
    public static void run()
    {
        Scanner in = new Scanner(System.in);
        M = in.nextInt();
        a = new long[M];
        
        for(int i = 0; i < M; i++)
        {
            a[i] = in.nextInt();
        }
        
        N = in.nextInt();
        b = new long[N];
        
        for(int i = 0; i < N; i++)
        {
            b[i] = in.nextInt();
        }
        
        Arrays.sort(a);
        Arrays.sort(b);
        
        int i=0,j=0;
        for(;  (i < M && j < N) && (a[i]<0 && b[j]<0);)
        {
            res += a[i++] * b[j++];
        }
        
        int k=M-1, l=N-1;

        for(; (k>=i && l>=j) && (a[k]>0 && b[l]>0) ;)
        {
            res += a[k--] * b[l--];
        }
        in.close();
        
        System.out.print(res);                
    }
       
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PAT1037.run();
    }

}
