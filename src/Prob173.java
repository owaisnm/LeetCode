import java.util.Stack;

public class Prob173 {
	
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 
	class BSTIterator {
	    
	    Stack<TreeNode> stack;

	    public BSTIterator(TreeNode root) {
	        stack = new Stack<>();
	        if(root != null) {
	            TreeNode curr = root;
	            stack.push(curr);
	            curr = curr.left;
	            while(curr != null) {
	                stack.push(curr);
	                curr = curr.left;
	            }
	        }
	    }
	    
	    /** @return the next smallest number */
	    public int next() {
	        
	        TreeNode curr = stack.pop();
	        int val = curr.val;
	        if(curr.right != null) {
	            stack.push(curr.right);
	            curr = curr.right;
	            while(curr.left != null) {
	                stack.push(curr.left);
	                curr = curr.left;
	            }
	        }
	        return val;
	    }
	    
	    /** @return whether we have a next smallest number */
	    public boolean hasNext() {
	        return !stack.isEmpty();
	    }
	}
}
