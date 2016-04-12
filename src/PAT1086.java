import java.util.Scanner;
import java.util.Stack;

public class PAT1086 {

    class Node
    {
        public int ID;
        public int value;
        public Node kid1,kid2;
        
        public Node(int ID, int value)
        {
            this.ID = ID;
            this.value = value;
        }
    }
    
    public int N;
    public Node root;
    public Node cur;
    public Stack<Integer> stack;
    
    public void run()
    {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        in.nextLine();
        
        int popID;
        stack = new Stack<Integer>();
        
        String tmp;
        String[] tmp1;
        int count = 2*N;
        int id = 0;
        while(count-- != 0)
        {
            tmp = in.nextLine();
            tmp1 = tmp.split(" ");
            if(tmp1.length == 2)
            {
                int value = Integer.parseInt(tmp1[1]);
                if(root == null) 
                {
                    stack.push(id);
                    root = new Node(id++, value);
                    cur = root;
                }
                else 
                {
                    if(cur.kid1 == null)
                    {
                        stack.push(id);
                        cur.kid1 = new Node(id++, value);
                        cur = cur.kid1;
                    }
                    else
                    {
                        stack.push(id);
                        cur.kid2 = new Node(id++, value);
                        cur = cur.kid2;
                    }
                }
            }
            else
            {
                popID = stack.pop();
                cur = findNode(root, popID);
            }
            popID = -1;
        }
        in.close();
        printPost(root);
    }
    
    private Node findNode(Node node,int id)
    {
        if(node == null) return null;
        if(node.ID == id) return node;
        else
        {
            Node resLeft = findNode(node.kid1, id);
            Node resRight = findNode(node.kid2, id); 
            return (resLeft == null)? resRight:resLeft;
        }

    }
    
    private void printPost(Node node)
    {
        if(node == null) return;
        if(node.kid1 == null && node.kid2 == null)
        {
            System.out.print(node.value);
            if(node.ID != root.ID)
            {
                System.out.print(" ");
            }
        }
        else
        {
            printPost(node.kid1);
            printPost(node.kid2);
            System.out.print(node.value);
            if(node.ID != root.ID)
            {
                System.out.print(" ");
            }
        }

    }
    
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        PAT1086 pat = new PAT1086();
        pat.run();
    }

}
