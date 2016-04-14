import java.util.Scanner;

public class PAT1035 {

    class User
    {  
        public String id;
        public String pass;
        public boolean modified = false;
        
        public User(String id, String pass)
        {
            this.id = id;
            this.pass = pass;
            replace();
        }
        
        public void replace()
        {
            if(pass.indexOf("1") != -1)
            {
                modified = true;
                pass = pass.replaceAll("1", "@");
            }
            
            if(pass.indexOf("0") != -1)
            {
                modified = true;
                pass = pass.replaceAll("0", "%");
            }
            
            if(pass.indexOf("l") != -1)
            {
                modified = true;
                pass = pass.replaceAll("l", "L");
            }
            
            if(pass.indexOf("O") != -1)
            {
                modified = true;
                pass = pass.replaceAll("O", "o");
            }
        }
        
        public String toString()
        {
            return id+" "+ pass;
        }
    }
    
    public User[] table;
    public int N;
    public int count = 0;
    public void run()
    {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        table = new User[N];
        
        for(int i = 0; i < N; i++)
        {
            table[i] = new User(in.next(),in.next());
            if(table[i].modified) count++;
        }
        
        if(count == 0)
        {
            if(N == 1)
            {
                System.out.print("There is 1 account and no account is modified");
            }
            else System.out.print("There are "+N+" accounts and no account is modified");
        }
        else
        {
            System.out.println(count);
            for(int i = 0; i < N; i++)
            {
                if(table[i].modified) System.out.println(table[i]);
            }
        }
        in.close();
        
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PAT1035 pat = new PAT1035();
        pat.run();
    }

}
