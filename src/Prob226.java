import java.util.LinkedList;

public class Prob226 {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return root;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode cursor;
        TreeNode left, right, tmp;
        left = right = null;
        queue.add(root);
        while(!queue.isEmpty()) {   
            cursor = queue.remove();
            if(cursor != null) {
                tmp = cursor.right;
                cursor.right = cursor.left;
                cursor.left = tmp;
                queue.add(cursor.left);
                queue.add(cursor.right);
            }
        }
        return root;
    }
}
