import java.util.Arrays;
import java.util.Scanner;

public class PAT1083 {
    
    class students implements Comparable
    {
        String name;
        String ID;
        int grade;
        
        students(String name, String ID, int grade)
        {
            this.name = name;
            this.ID = ID;
            this.grade = grade;
        }

        @Override
        public int compareTo(Object o) {
            students st = (students) o;
            if(st.grade > this.grade) return 1;
            else if(st.grade < this.grade) return -1;
            else return 0;
        }
    }
    
    public void run()
    {
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        students[] group = new students[N];
        
        String tmpname;
        String tmpID;
        int tmpgrade;
        for(int i = 0; i < N; i++)
        {
            tmpname = in.next();
            tmpID = in.next();
            tmpgrade = in.nextInt();
            group[i] = new students(tmpname, tmpID, tmpgrade);
        }
        
        int low = in.nextInt();
        int high = in.nextInt();
        
        in.close();
        Arrays.sort(group);
        boolean flag = false;
        
        for(int i = 0; i < N; i++)
        {
            if(group[i].grade >= low && group[i].grade <= high)
                {
                    System.out.println(group[i].name + " " + group[i].ID);
                    flag = true;
                }
        }
        
        if(!flag) System.out.println("None");
    }
    
    public static void main(String args[])
    {
        PAT1083 pat = new PAT1083();
        pat.run();
    }
    
}
