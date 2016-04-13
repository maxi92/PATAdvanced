import java.util.Scanner;

public class PAT1027 {

    public static String conv(int color)
    {
        StringBuilder res = new StringBuilder();
        int tmp = 0;
        while(color != 0)
        {
            tmp = color % 13;
            if(tmp >= 10)
            {
                res.insert(0,(char)('A'+(tmp-10)));
            }
            else 
            {
                res.insert(0, tmp+"");
            }
            color = color / 13;
        }
        if(res.length() < 2)
            res.insert(0, "0");
        return res.toString();
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner in = new Scanner(System.in);
        
        int red, green, blue;
        
        red = in.nextInt();
        green = in.nextInt();
        blue = in.nextInt();
        in.close();
        
        System.out.print("#"+PAT1027.conv(red)+PAT1027.conv(green)+PAT1027.conv(blue));
        
    }

}
