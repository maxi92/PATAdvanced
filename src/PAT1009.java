import java.util.Scanner;


public class PAT1009 {

    private double[] list1;
    private double[] list2;
    private double[] result;
    
    public PAT1009()
    {
        Scanner in = new Scanner(System.in);
        
        int K1 = in.nextInt();
        list1 = new double[1001];
        for(int i = 0; i < K1; i++)
        {
            int exp = in.nextInt();
            double coe = in.nextDouble();
            list1[exp] = coe;
        }
        
        int K2 = in.nextInt();
        list2 = new double[1001];
        for(int i = 0; i < K2; i++)
        {
            int exp = in.nextInt();
            double coe = in.nextDouble();
            list2[exp] = coe;
        }
        
        result = new double[2002];
    }
    
    public void cal()
    {
        for(int i = 0; i < 1001; i++)
            for(int j = 0; j < 1001; j++)
            {
                int exp = i + j;
                double coe = list1[i] * list2[j];
                if(coe != 0) result[exp] += coe;
            }
    }
    
    public void print()
    {
        int count = 0;
        for(int i = 0; i < 2002; i++)
        {
            if(result[i] != 0)
                count++;
        }
        
        System.out.print(count);
        
        for(int i = 2001; i >= 0; i--)
        {
            if(result[i] != 0)
                System.out.printf(" %d %.1f",i,result[i]);
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PAT1009 pat = new PAT1009();
        pat.cal();
        pat.print();
    }

}
