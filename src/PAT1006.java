import java.util.Scanner;


public class PAT1006 {

    private identity[] list;
    
    private class identity{
        public String name;
        public String come;
        public String go;
        
        public boolean comeCompare(identity id)
        {
            String[] time1 = this.come.split(":");
            int hour1 = Integer.parseInt(time1[0]);
            int min1 = Integer.parseInt(time1[1]);
            int second1 = Integer.parseInt(time1[2]);
            
            String[] time2 = id.come.split(":");
            int hour2 = Integer.parseInt(time2[0]);
            int min2 = Integer.parseInt(time2[1]);
            int second2 = Integer.parseInt(time2[2]);
            
            if(hour1 > hour2) return true;
            else if(hour1 < hour2) return false;
            
            if(min1 > min2) return true;
            else if(min1 < min2) return false;
            
            if(second1 > second2) return true;
            else if(second1 < second2) return false;
            
            return false;
        }
        
        public boolean goCompare(identity id)
        {
            String[] time1 = this.go.split(":");
            int hour1 = Integer.parseInt(time1[0]);
            int min1 = Integer.parseInt(time1[1]);
            int second1 = Integer.parseInt(time1[2]);
            
            String[] time2 = id.go.split(":");
            int hour2 = Integer.parseInt(time2[0]);
            int min2 = Integer.parseInt(time2[1]);
            int second2 = Integer.parseInt(time2[2]);
            
            if(hour1 > hour2) return true;
            else if(hour1 < hour2) return false;
            
            if(min1 > min2) return true;
            else if(min1 < min2) return false;
            
            if(second1 > second2) return true;
            else if(second1 < second2) return false;
            
            return false;
        }
        
    }
    
    public PAT1006()
    {
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        String dummy = in.nextLine();
        list = new identity[num];
        
        for (int i = 0; i < num; i++)
        {
            list[i] = new identity();
            String temp = in.nextLine();
            String test = "test";
            String[] tmp = temp.split(" ");
            list[i].name = tmp[0];
            list[i].come = tmp[1];
            list[i].go = tmp[2];
            
        }
        
        in.close();
        
        int comeindex = 0;
        int goindex = 0;
        
        for(int i = 1; i < num; i++)
        {
            if(!list[i].comeCompare(list[comeindex]))
            {
                comeindex = i;
            }
            
            if(list[i].goCompare(list[goindex]))
            {
                goindex = i;
            }
        }
        
        System.out.print(list[comeindex].name+" "+list[goindex].name);
    }
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PAT1006 pat = new PAT1006();
    }

}
