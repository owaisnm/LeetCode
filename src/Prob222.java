import java.util.LinkedList;

public class Prob222 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public int countNodes(TreeNode root) {
        //recursive
        if(root == null) {
            return 0;
        }
        int left = 1 + countNodes(root.left) ;
        int right = 1 + countNodes(root.right);
        return left+right -1;
            
        //iterative:
        /*int length = 0;
        if(root == null) {
            return length;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        length++;
        TreeNode cursor;
        while(!queue.isEmpty()) {
            cursor = queue.remove();
            if(cursor.left != null) {
                queue.add(cursor.left);
                length++;
            } 
            if(cursor.right != null) {
                queue.add(cursor.right);
                length++;
            } 
        }
        return length;
        */
    }
}
