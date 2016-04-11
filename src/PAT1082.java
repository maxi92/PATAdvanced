import java.util.Scanner;
 
public class PAT1082 {
    public static String num;
    public static String[] digit = {"ling","yi","er","san","si","wu","liu","qi","ba","jiu"};
    public static String[] weight = {"Yi","Wan","Qian","Bai","Shi"};
     
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        num = sc.nextLine();
        sc.close();
        if (num.charAt(0) == '-')
        {
            System.out.print("Fu ");
            num = num.substring(1);
        }
        
        int bits = num.length(); 
        switch(bits){ 
        case 1: 
        case 2: 
        case 3: 
        case 4: 
            if(!readNum(num, 3)) System.out.print("ling"); 
            break; 
        case 5:{ 
            int wan = char2int(num.charAt(0)); 
            System.out.printf("%s Wan",digit[wan]);
            if(!readNum(num.substring(1),3)) System.out.print("");
            break; 
        } 
        case 6:{ 
            readNum(num.substring(0,2),1); 
            System.out.printf("Wan");
            readNum(num.substring(2),2); 
            break; 
        } 
        case 7:{ 
            readNum(num.substring(0,3),1); 
            System.out.printf("Wan"); 
            readNum(num.substring(3),2); 
            break; 
        } 
        case 8:{ 
            if(readNum(num.substring(0,4),1)) 
            System.out.printf("Wan"); 
            if(!readNum(num.substring(4),2))
                System.out.print("ling");; 
            break; 
        } 
        case 9:{ 
            int yi = char2int(num.charAt(0));
            System.out.printf(digit[yi] + " Yi"); 
            if(!readNum(num.substring(1,5),3));
            else System.out.printf("Wan"); 
            readNum(num.substring(5),2); 
            break; 
        } 
        } 
    }
     
    public static boolean readNum(String nums, int position)
    {
        int bits = nums.length();
         
        boolean printZero = false;
        switch(bits){
        case 1:{
            int ge = char2int(nums.charAt(0));
            if(ge == 0) return false;
            System.out.print(digit[ge]);
            break;
        }
        case 2:{
            int ge = char2int(nums.charAt(1));
            int shi = char2int(nums.charAt(0));
            if(shi == 0 && ge == 0) return false;
            if(shi != 0) System.out.print(digit[shi]+" Shi");
            else if(!printZero){
                System.out.print(" ling");
                printZero = true;
            }
            if(ge != 0) System.out.print(" "+digit[ge]);
            break;
        }
        case 3:{
            int bai = char2int(nums.charAt(0)); 
            int shi = char2int(nums.charAt(1)); 
            int ge = char2int(nums.charAt(2));
            if(bai ==0 && shi == 0 && ge == 0) return false;
            if(bai != 0)
            {   System.out.print(digit[bai]+" Bai");
                printZero = false;
            } 
            else if(!printZero && (shi !=0 || ge != 0)){ 
                System.out.print(" ling"); 
                printZero = true; 
            } 
             
            if(shi != 0)
            {
                System.out.print(" "+ digit[shi]+" Shi");
                printZero = false;
            } 
            else if(!printZero && ge!=0){ 
                System.out.print(" ling"); 
                printZero = true; 
            }
             
            if(ge != 0) System.out.printf(" %s",digit[ge]); 
            break; 
        }
        case 4:{ 
            int qian = char2int(nums.charAt(0));
            int bai = char2int(nums.charAt(1)); 
            int shi = char2int(nums.charAt(2)); 
            int ge = char2int(nums.charAt(3));  
            if(bai ==0 && shi == 0 && ge == 0 && qian == 0) return false;
            if(qian != 0) {
                if(position == 1)
                    System.out.printf("%s Qian ",digit[qian]); 
                else
                    System.out.printf(" %s Qian",digit[qian]);
                printZero = false;
            } 
            else if(!printZero && (bai!=0 || shi!=0 || ge!=0)){ 
                System.out.printf("ling "); 
                printZero = true; 
            } 
            if(bai != 0) {
                if(position == 1)
                    System.out.printf("%s Bai ",digit[bai]);
                else
                    System.out.printf(" %s Bai",digit[bai]);
                printZero = false;
                } 
            else if(!printZero && (shi != 0 || ge != 0)){ 
                System.out.printf("ling "); 
                printZero = true; 
            } 
            if(shi != 0) {
                if(position == 1)
                    System.out.printf("%s Shi ",digit[shi]);
                else System.out.printf(" %s Shi",digit[shi]);
                printZero = false;
                } 
            else if(!printZero && ge != 0){ 
                System.out.printf("ling "); 
                printZero = true; 
            } 
            if(ge != 0) 
            {
                if(position == 1)
                    System.out.printf("%s ",digit[ge]);
                else if(position == 2)
                    System.out.printf(" %s",digit[ge]);
                else if(position == 3)
                    System.out.printf(" %s ",digit[ge]);
            }
            else 
            {
                if(position == 1)
                    System.out.printf("");
                else if(position == 2)
                    System.out.printf("");
                else if(position == 3)
                    System.out.printf(" ");
            }
        } 
        }
        return true;
    }
     
    public static int char2int(char c)
    {
        return c-'0';
    }
}