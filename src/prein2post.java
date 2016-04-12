/*
 * 依据前序和中序遍历获取后序遍历的结果
 * 其大致思路是
 * 先用前序遍历获取根结点，然后在中序遍历中，利用根结点将树分为两个子树，然后重复上述动作
 * 利用递归进行查找
 * 详细的思路可以查看收藏的网页
 */
import java.util.Scanner;

public class prein2post {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String pre_order,in_order;
        Scanner in = new Scanner(System.in);
        pre_order = in.next();
        in_order = in.next();
        in.close();
        prein2post.findPost(pre_order,in_order);
    }
    
    public static void findPost(String pre, String in)
    {
        if(pre.length() == 1)
        {
            System.out.print(pre);
            return;
        }
        
        if(pre.length() == 0)
            return;
        
        char tmp = pre.charAt(0);
        int pos = in.indexOf(tmp);
       
        findPost(pre.substring(1,pos+1), in.substring(0, pos));
        findPost(pre.substring(pos+1), in.substring(1+pos));
        System.out.print(tmp);
    }
    

}
