import java.util.Stack;

public class Prob114 {
	public class TreeNode {
		      int val;
		     TreeNode left;
		      TreeNode right;
		     TreeNode(int x) { val = x; }
	  }
	 public void flatten(TreeNode root) {
	        if(root == null) {
	            return;
	        }
	        
	        Stack<TreeNode> stack = new Stack<>();
	        stack.push(root);
	        TreeNode preCursor, cursor;
	        preCursor = cursor = null;
	        
	        while(!stack.isEmpty()) {
	            cursor = stack.pop();
	            if(preCursor != null) {
	                preCursor.left = null;
	                preCursor.right = cursor;
	            }
	            if(cursor.right != null) {
	                stack.push(cursor.right);
	            }
	            if(cursor.left != null) {
	                stack.push(cursor.left);
	            }        
	            preCursor = cursor;
	        }
	    }
}
