
import static java.lang.System.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class PAT1036 {

    class student implements Comparable<student>
    {
        public String name;
        public String id;
        public int grade;
        
        public student(String name, String id, int grade)
        {
            this.name = name;
            this.id = id;
            this.grade = grade;
        }
        
        public int compareTo(student b)
        {
            if(this.grade > b.grade) return 1;
            else if(this.grade < b.grade) return -1;
            else return 0;
        }
        
        public String toString()
        {
            return name+" "+id;
        }
    }
    
    public ArrayList<student> male;
    public ArrayList<student> female;
    public int N;
    
    public void run()
    {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        male = new ArrayList<student>();
        female = new ArrayList<student>();
        
        for(int i = 0; i < N; i++)
        {
            String name = in.next();
            String gender = in.next();
            String id = in.next();
            int grade = in.nextInt();
            if(gender.equals("M"))
            {
                male.add(new student(name,id,grade));
            }
            else female.add(new student(name,id,grade)); 
        }
        
        Collections.sort(male);
        Collections.sort(female);
        in.close();
        
        if(male.isEmpty())
        {       
            if(female.isEmpty())
            {
                out.println("Absent");
                out.println("Absent");
                out.print("NA");
            }
            else 
            {
                out.println(female.get(female.size()-1));
                out.println("Absent");
                out.print("NA");
            }                
        }
        else
        {
            if(female.isEmpty())
            {
                out.println("Absent");
                out.println(male.get(0));
                out.print("NA");
            }
            else 
            {
                out.println(female.get(female.size()-1));
                out.println(male.get(0));
                out.print(female.get(female.size()-1).grade - male.get(0).grade);
            }         
        }

    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PAT1036 pat = new PAT1036();
        pat.run();
    }

}
