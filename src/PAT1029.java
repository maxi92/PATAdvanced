/*
 * 这道题是一道经典的求两个有序数列的合并数列的中位数的问题
 * 利用的是归并的思想，但是如果只是求中位数的话可以不实际进行归并
 * 只移动游标即可
 * 因为中位数必然是最后那个大数组的中间位置，所以游标一共移动那么多次就可以了
 * 剩下的工作就是，把两个数组当成一个数组，按照从小到大的顺序遍历过去就好
 * 遍历到最后比较一下游标指向的两个数，更小的那个就该排在前面，于是中位数就是它
 * 代码写得很清楚了
 */
import static java.lang.System.*;

import java.io.*;

public class PAT1029 {
    
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String tmp = br.readLine();
        String[] tmp1 = tmp.split(" ");
        int s1 = Integer.parseInt(tmp1[0]);
        long[] a = new long[s1+1];
        
        for(int i = 0; i < s1; i++)
        {
            a[i] = Long.parseLong(tmp1[i+1]);
        }
        
        String tmp2 = br.readLine();
        String[] tmp3 = tmp2.split(" ");
        int s2 = Integer.parseInt(tmp3[0]);
        long[] b = new long[s2+1];
        
        for(int i = 0; i < s2; i++)
        {
            b[i] = Long.parseLong(tmp3[i+1]);
        }
        
        br.close();
        a[s1] = 0x7fffffff;
        b[s2] = 0x7fffffff;
        
        int i = 0;
        int j = 0;
        int count = 0;
        
        while(count<(s1+s2-1)/2)
        {
            if(a[i] < b[j]) i++;
            else j++;
            
            count++;
            
        }
        
        if(a[i] <= b[j]) out.print(a[i]);
        else out.print(b[j]);
    }
}
