import java.util.Scanner;


public class PAT1008 {

    public PAT1008()
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        int[] list = new int[N];
        
        for(int i = 0; i < N; i++)
        {
            list[i] = in.nextInt();
        }
        in.close();
        
        int sum = list[0] * 6;
        for(int i = 0; i < N - 1; i++)
        {
            sum += 5;
            if(list[i] < list[i+1])
            {
                sum += (list[i+1] - list[i]) * 6;
            }
            else
            {
                sum += (list[i] - list[i+1]) * 4;
            }
        }
        sum +=5;
        
        System.out.println(sum+"");
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PAT1008 pat = new PAT1008();
    }

}
