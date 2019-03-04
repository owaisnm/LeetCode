public class Prob701 {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	   public TreeNode insertIntoBST(TreeNode root, int val) {
	        return insert(root, val);
	    }
	    
	    TreeNode insert(TreeNode root, int val) {
	        if(root.val < val) {
	            if(root.right != null) {
	                insert(root.right, val);
	            } else {
	                root.right = new TreeNode(val);
	            }
	        } else {
	            if(root.left != null) {
	                insert(root.left, val);
	            } else {
	                root.left = new TreeNode(val);
	            }
	        }
	        return root;
	    }
}
