import java.util.Scanner;

public class ABformat {

    
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int a = in.nextInt();
        int b = in.nextInt();
        
        int sum = a+b;
        if (sum < 0) 
        {
            System.out.print("-");
            sum = -sum;
        }
        String formatsum = ((Integer) sum).toString();
        
        int m = 0;
        int n = formatsum.length()%3;
        System.out.print(formatsum.substring(m, n));
        
        for (int i = n; i< formatsum.length(); i +=3)
        {
            if(i != 0) System.out.print(",");
            System.out.print(formatsum.substring(i, i+3));
        }
    }

}
