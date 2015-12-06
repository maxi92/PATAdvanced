/*
 * 这道题开始想的是用Brutal的方法，扫描所有的可能序列，但是那种方法的时间复杂度是O（n^2)
 * 后来看了别人的程序才发现可以在O(n)的时间内解决
 * 思路就是，从头到尾扫描这个序列，并进行累加，如果遇到累加值小于零了，说明前面这部分没有必要留到后面去，所以清空累加器
 * 如果累加值没有小于零，那么就用一个max来记录目前的最大值，并且用一个start和end来指向最大和的序列的头尾
 * 需要注意的是，如果最后和是负数（最有可能的情况是所有数都是负数），那么和为0，并且头尾分别是原序列的头尾
 * 最初将max置为-1而不是0，这样如果全为负数那么最终max还是-1，这样将max输出就能得到正确的结果
 */

import java.util.Scanner;


public class PAT1007 {

    public PAT1007()
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        String dummy = in.nextLine();
        int[] list = new int[N];
        int sum = 0;
        int end = list.length - 1;
        int start = 0;
        int max = -1;
        int temp = 0;
        
        for(int i = 0; i < N; i++)
        {
            list[i] = in.nextInt();
        }
        
        for(int i = 0; i < N; i++)
        {
            sum += list[i];
            if(sum < 0)
            {
                sum = 0;
                temp = i+1;
                
            }
            else if(sum > max)
            {
                max  = sum;
                end = i;
                start = temp;
            }
        }
        
        if(max < 0)
        {
            max = 0;
        }
        System.out.print(""+max+" "+list[start]+" "+list[end]);
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PAT1007 pat = new PAT1007();
    }

}
