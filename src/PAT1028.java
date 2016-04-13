import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class PAT1028 {

    public int N,C;
    public Student[] record;
    
    public void run()
    {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        C = in.nextInt();
        
        record = new Student[N];
        
        for(int i = 0; i < N; i++)
        {
            record[i] = new Student(in.nextInt(), in.next(), in.nextInt());
        }
        
        if(C == 1) Arrays.sort(record, new myComparator1());
        else if (C == 2)
            Arrays.sort(record, new myComparator2());
        else if(C == 3)
            Arrays.sort(record, new myComparator3());
        
        for(int i=0; i < N; i++)
        {
            String id = record[i].ID + "";
            int dif = 6 - id.length();
            for(int j = 0; j < dif; j++)
                id = "0"+id;
            System.out.println(id+" "+record[i].name+" "+record[i].grade);
        }
        in.close();
            
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PAT1028 pat = new PAT1028();
        pat.run();
        
    }
    
    class Student
    {
        public int ID;
        public String name;
        public int grade;
        
        Student(int ID, String name, int grade)
        {
            this.ID = ID;
            this.name = name;
            this.grade = grade;
        }
               
    }
    
    class myComparator1 implements Comparator<Student>
    {
        public int compare(Student a, Student b)
        {
            if(a.ID > b.ID) return 1;
            else if(a.ID < b.ID) return -1;
            else return 0;
        }
    }
    
    class myComparator2 implements Comparator<Student>
    {
        public int compare(Student a, Student b)
        {
            int res = a.name.compareTo(b.name);
            if (res !=0 ) return res;
            else 
            {
                if(a.ID > b.ID) return 1;
                else if(a.ID < b.ID) return -1;
                else return 0;
            }
        }
    }
    
    class myComparator3 implements Comparator<Student>
    {
        public int compare(Student a, Student b)
        {
            
            if(a.grade > b.grade) return 1;
            else if(a.grade < b.grade) return -1;
            else 
            {
                if(a.ID > b.ID) return 1;
                else if(a.ID < b.ID) return -1;
                else return 0;
            }
        }
    }
}
