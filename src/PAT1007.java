/*
 * ����⿪ʼ�������Brutal�ķ�����ɨ�����еĿ������У��������ַ�����ʱ�临�Ӷ���O��n^2)
 * �������˱��˵ĳ���ŷ��ֿ�����O(n)��ʱ���ڽ��
 * ˼·���ǣ���ͷ��βɨ��������У��������ۼӣ���������ۼ�ֵС�����ˣ�˵��ǰ���ⲿ��û�б�Ҫ��������ȥ����������ۼ���
 * ����ۼ�ֵû��С���㣬��ô����һ��max����¼Ŀǰ�����ֵ��������һ��start��end��ָ�����͵����е�ͷβ
 * ��Ҫע����ǣ���������Ǹ��������п��ܵ���������������Ǹ���������ô��Ϊ0������ͷβ�ֱ���ԭ���е�ͷβ
 * �����max��Ϊ-1������0���������ȫΪ������ô����max����-1��������max������ܵõ���ȷ�Ľ��
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
        in.close();
        
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
