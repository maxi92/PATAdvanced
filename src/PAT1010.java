/*
 * 本问题不容易拿满分，有几个问题需要注意
 * 第一，N2这个数进制的下限是N2所有位数字上最大的数字+1，上限是N1+1（因为如果进制比这个还大，即使用N2=1，N2也比N1大，这是不可能的）
 * 第二，注意N2的进制上限并不是37，这个在题目中不容易读明白
 * 第三，注意使用二分搜索来节约时间
 * 第四，程序里有一个standard1 == convert(N2.charAt(0)) && N2.length() == 1的判断语句，我不知道为什么要加这一句
 * 但是如果不加OJ会有一个用例过不了，这个留存一个疑问
 * 最后要注意二分搜索的循环条件是low <= high，可以取等
 */

import java.util.Scanner;


public class PAT1010 {

    private String N1;
    private String N2;
    private int tag;
    private int radix;
    public PAT1010()
    {
       Scanner in = new Scanner(System.in);
       String[] line = in.nextLine().split(" ");
       N1 = line[0];
       N2 = line[1];
       tag = Integer.parseInt(line[2]);
       radix = Integer.parseInt(line[3]);
       
       compare();
    }
    
    private void compare()
    {
        long standard1 = 0;
        long standard2 = 0;
        if(tag == 1)
        {
            standard1 = radix(N1, radix);

            int maxdigit = 0;
            for(int i = 0; i < N2.length(); i++)
            {
                char tmp = N2.charAt(i);
                int digit = convert(tmp);
                if (digit > maxdigit)
                {
                    maxdigit = digit;
                }
            }
            
            if(standard1 == convert(N2.charAt(0)) && N2.length() == 1)
            {
                System.out.print(maxdigit+1);
                return;
            }
            
            long low = maxdigit + 1;
            long high = standard1 + 1;
            long mid = (low + high)/2;
            
            while(low <= high)
            {
                mid = (low + high)/2;
                standard2 = radix(N2, mid);
                if(standard2 == standard1)
                {
                    System.out.print(mid+"");
                    return;
                }
                if(standard2 > standard1 || standard2 == -1)
                    high = mid - 1;
                if(standard2 < standard1)
                    low = mid + 1;
            }
            
            System.out.print("Impossible");

        }
        else if(tag == 2)
        {

            standard1 = radix(N2, radix); 
            
            int maxdigit = 0;
            for(int i = 0; i < N1.length(); i++)
            {
                char tmp = N1.charAt(i);
                int digit = convert(tmp);
                if (digit > maxdigit)
                {
                    maxdigit = digit;
                }
            }
            
            if(standard1 == convert(N1.charAt(0)) && N1.length() == 1)
            {
                System.out.print(maxdigit+1);
                return;
            }
            
            long low = maxdigit;
            long high = standard1 + 1;
            long mid = (low + high)/2;
            
            while(low <= high)
            {
                mid = (low + high)/2;
                standard2 = radix(N1, mid);
                if(standard2 == standard1)
                {
                    System.out.print(mid+"");
                    return;
                }
                if(standard2 > standard1 || standard2 == -1)
                    high = mid - 1;
                if(standard2 < standard1)
                    low = mid + 1;
            }
            
            System.out.print("Impossible");
        }

    }
    
    private int convert(char digit)
    {
        if('0' <= digit && digit <= '9')
        {
            return Integer.parseInt(digit+"");
        }
        else
        {
            return digit - 'a' + 10;
        }
    }
    
    private long radix(String N, long radix)
    {
        long standard = 0;
        for(int i = 0; i < N.length(); i++)
        {
            char tmp = N.charAt(i);
            int digit = convert(tmp);
            standard += digit * Math.pow(radix, N.length() - i - 1);
        }
        if(standard < 0) return -1;
        return standard;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub

        PAT1010 pat = new PAT1010();
    }

}
