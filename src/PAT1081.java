import java.util.Scanner;

public class PAT1081 {

    public static long[] denominator;
    public static long[] numerator;
    
    public static long LCM(long a,long b)
    {
        long aa=a;
        long bb=b;
        long c = a%b;
        while(c!=0)
        {
            a=b;
            b=c;
            c = a%b;
        }
        return aa*bb/b;
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        
        denominator = new long[num];
        numerator = new long[num];
        sc.nextLine();
        String input = sc.nextLine();
        String[] fraction = input.split(" ");
        sc.close();
        
        for (int i=0; i<num; i++)
        {
            String[] tmp = fraction[i].split("/");
            if(tmp[0].charAt(0) == '-')
            {
                numerator[i] = -Integer.parseInt(tmp[0].substring(1));
                denominator[i] = Integer.parseInt(tmp[1]);
            }
            else
            {
                numerator[i] = Integer.parseInt(tmp[0]);
                denominator[i] = Integer.parseInt(tmp[1]);
            }
            //System.out.println(numerator[i]+"/"+denominator[i]);
        }
        
        long res = LCM(denominator[0],denominator[1]);
        for (int i=2; i < num; i++)
        {
            res = LCM(res,denominator[i]);
        }
        
        long sum = 0;
        for(int i=0; i < num; i++)
        {
            sum = sum + numerator[i]*(res/denominator[i]);
        }
        
        long numInt = sum / res;
        long numFrac = sum % res;
        
        long lcd=0;
        if(numFrac != 0)
        lcd = numFrac*res/LCM(numFrac,res);
        
        long fenzi = 0; 
        long fenmu =0;
        if(numFrac != 0)
        {
        fenzi = numFrac/lcd;
        fenmu = res/lcd;
        if(fenzi<0 && fenmu<0){fenzi=-fenzi;fenmu=-fenmu;}
        else if(fenzi > 0 && fenmu < 0){fenzi= -fenzi; fenmu= -fenmu;}
        }
        
        //System.out.println("numFrac:"+numFrac+","+lcd);
        if(numInt == 0 && numFrac ==0)
            System.out.println(0);
        else if(numInt == 0 && numFrac != 0)
            System.out.println(fenzi+"/"+fenmu);
        else if(numInt !=0 && numFrac == 0)
            System.out.println(numInt);
        else System.out.println(numInt+" "+fenzi+"/"+fenmu);
        
    }

}
