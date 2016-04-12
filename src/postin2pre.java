/*
 * 依据中序遍历和后序遍历获取前序遍历的结果
 * 思路和prein2post相同，不同之处在于后序遍历根结点在最后，并且根结点左边一位是右子节点
 * 其余方法相同
 */
import java.util.Scanner;

public class postin2pre {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String post_order,in_order;
        Scanner in = new Scanner(System.in);
        post_order = in.next();
        in_order = in.next();
        postin2pre.findPre(post_order,in_order);
        in.close();
    }
    
    public static void findPre(String post, String in)
    {
        if(post.length() == 1)
        {
            System.out.print(post);
            return;
        }
        
        if(post.length() == 0)
            return;
        
        char tmp = post.charAt(post.length()-1);
        int pos = in.indexOf(tmp);
        
        System.out.print(tmp);
        findPre(post.substring(0,pos),in.substring(0,pos));
        findPre(post.substring(pos, post.length()-1), in.substring(pos+1));
    }

}
