/*
 * 这道题本来很简单，结果在判断素数的地方栽了跟头
 * 首先i能够取到根号N
 * 其次不要忘了N等于0和1时候的情况
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class PAT1015 {

    public static boolean isPrime(int N)
    {
        if(N == 0 || N == 1) return false;
        for(int i = 2; i <= Math.sqrt(N);i++ )
        {
            if(N % i == 0)
                return false;
        }
        return true;
    }
    
    public static String radixn(int N, int radix)
    {
        String result = new String();
        result = "";
        int tmp = N;
        int res;
        while(tmp != 0)
        {
            res = tmp % radix;
            result = res + result;
            tmp = tmp / radix;
        }
        return result;
    }
    
    public static String reverse(String s)
    {
        int n = s.length();
        String result = new String();
        result = "";
        for(int i = 0; i < n; i++)
        {
            result = s.charAt(i) + result;
        }
        return result;
    }
    
    public static int radix10(String s, int radix)
    {
        int n = s.length();
        int sum = 0;
        for(int i = 0; i < n; i++)
        {
            int digit = Integer.parseInt("" + s.charAt(i));
            sum += digit * Math.pow(radix, n-1-i);
        }
        return sum;
    }
    
    public static void main(String args[]) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String[] tmp = str.split(" ");
        int N = Integer.parseInt(tmp[0]);
        if (N < 0) return;
        int radix = Integer.parseInt(tmp[1]);
        
        String rn = new String();
        
        while(true)
        {
           if(isPrime(N))
           {
               rn = radixn(N, radix);
               String rrn = reverse(rn);
               int rr10 = radix10(rrn, radix);
               if(isPrime(rr10))
                   System.out.println("Yes");
               else System.out.println("No");
           }
           else System.out.println("No");
           
           str = br.readLine();
           tmp = str.split(" ");
           N = Integer.parseInt(tmp[0]);
           if (N < 0) break;
           radix = Integer.parseInt(tmp[1]);
        }
    }
}
