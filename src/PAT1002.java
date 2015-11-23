import java.util.Scanner;

public class PAT1002 {

    private Node starta;
    private Node startb;
    private Node startc;
    public int count = 0;
    
    private class Node{
        private double coeffcient = -1;
        private int exponent = -1;
        private Node next;
    }
    
    private void input()
    {
        starta = new Node();
        Node node =  starta;
        Scanner in = new Scanner(System.in);
        int N = in.nextInt();
        for (int i=0; i<N; i++)
        {
            node.exponent = in.nextInt();
            node.coeffcient = in.nextDouble();
            if(i != N-1)
            {
                node.next = new Node();
                node = node.next;
            }
        }
        
        startb = new Node();
        node = startb;
        N = in.nextInt();
        for (int i=0; i<N; i++)
        {
            node.exponent = in.nextInt();
            node.coeffcient = in.nextDouble();
            if(i != N-1)
            {
                node.next = new Node();
                node = node.next;
            }
        }
    }
    
    private void merge()
    {
        Node nodea = starta;
        Node nodeb = startb;
        startc = new Node();
        Node nodec = startc;
        while(nodea != null && nodeb != null)
        {
            if(nodea.exponent == -1)
            {
                nodea =null;
                continue;
            }
            
            if(nodeb.exponent == -1)
            {
                nodeb = null;
                continue;
            }
            
            if(nodea.exponent == nodeb.exponent)
            {
                if(nodea.coeffcient + nodeb.coeffcient == 0)
                {
                    nodea = nodea.next;
                    nodeb = nodeb.next;
                    continue;    
                }
                nodec.exponent = nodea.exponent;
                nodec.coeffcient = nodea.coeffcient + nodeb.coeffcient;
                nodea = nodea.next;
                nodeb = nodeb.next;
                nodec.next = new Node();
                nodec = nodec.next;
                count++;
            }
            else if(nodea.exponent > nodeb.exponent)
            {
                nodec.exponent = nodea.exponent;
                nodec.coeffcient = nodea.coeffcient;
                nodea = nodea.next;
                nodec.next = new Node();
                nodec = nodec.next;
                count++;
            }
            else if(nodea.exponent < nodeb.exponent)
            {
                nodec.exponent = nodeb.exponent;
                nodec.coeffcient = nodeb.coeffcient;
                nodeb = nodeb.next;
                nodec.next = new Node();
                nodec = nodec.next;
                count++;
            }
        }
        
        if(nodea != null)
        {
            while(nodea != null)
            {
                nodec.coeffcient = nodea.coeffcient;
                nodec.exponent = nodea.exponent;
                nodea = nodea.next;
                nodec.next = new Node();
                nodec = nodec.next;
                count++;
            }
        }
        if(nodeb != null)
        {
            while(nodeb != null)
            {
                nodec.coeffcient = nodeb.coeffcient;
                nodec.exponent = nodeb.exponent;
                nodeb = nodeb.next;
                nodec.next = new Node();
                nodec = nodec.next;
                count++;
            }
        }
    }
    
    private void printout()
    {
        System.out.print(count);
        if(count !=0) System.out.print(" ");
        Node node = startc;
        for(int i=0; i<count; i++)
        {
            if(node.coeffcient == 0.0)
            {
                node = node.next;
                continue;
            }
            System.out.print(node.exponent+" ");
            System.out.printf("%.1f",node.coeffcient);
            if(i != count-1)
                System.out.print(" ");
            node = node.next;
        }
    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PAT1002 pat = new PAT1002();
        pat.input();
        pat.merge();
        pat.printout();
    }

}
