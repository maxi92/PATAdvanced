import java.util.Scanner;


public class PAT1005 {

    private String input;
    public PAT1005()
    {
        int sum = 0;
        Scanner in = new Scanner(System.in);
        input = in.nextLine();
        in.close();
        for(int i = 0; i < input.length(); i++)
        {
            char digit = input.charAt(i);
            int num = Integer.parseInt(digit + "");
            sum += num; 
        }
        
        String tmp = sum+"";
        
        for (int i = 0; i < tmp.length(); i++)
        {
            if((tmp.charAt(i) + "").equals("0")) 
            {
                System.out.print("zero");
                if(i != tmp.length() - 1)
                    System.out.print(" ");
            }
            
            if((tmp.charAt(i) + "").equals("1")) 
            {
                System.out.print("one");
                if(i != tmp.length() - 1)
                    System.out.print(" ");
            }
            
            if((tmp.charAt(i) + "").equals("2")) 
            {
                System.out.print("two");
                if(i != tmp.length() - 1)
                    System.out.print(" ");
            }
            
            if((tmp.charAt(i) + "").equals("3")) 
            {
                System.out.print("three");
                if(i != tmp.length() - 1)
                    System.out.print(" ");
            }
            
            if((tmp.charAt(i) + "").equals("4")) 
            {
                System.out.print("four");
                if(i != tmp.length() - 1)
                    System.out.print(" ");
            }
            
            if((tmp.charAt(i) + "").equals("5")) 
            {
                System.out.print("five");
                if(i != tmp.length() - 1)
                    System.out.print(" ");
            }
            
            if((tmp.charAt(i) + "").equals("6")) 
            {
                System.out.print("six");
                if(i != tmp.length() - 1)
                    System.out.print(" ");
            }
            
            if((tmp.charAt(i) + "").equals("7")) 
            {
                System.out.print("seven");
                if(i != tmp.length() - 1)
                    System.out.print(" ");
            }
            
            if((tmp.charAt(i) + "").equals("8")) 
            {
                System.out.print("eight");
                if(i != tmp.length() - 1)
                    System.out.print(" ");
            }
            
            if((tmp.charAt(i) + "").equals("9")) 
            {
                System.out.print("nine");
                if(i != tmp.length() - 1)
                    System.out.print(" ");
            }
            
        }
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PAT1005 pat = new PAT1005();

    }

}
