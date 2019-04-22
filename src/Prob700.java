
public class Prob700 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 public TreeNode searchBST(TreeNode root, int val) {
	        if(root.val == val) {
	            return root;
	        }
	        
	        TreeNode cursor = root;
	        while(cursor != null && val != cursor.val) {
	            if(val < cursor.val) {
	                cursor = cursor.left;
	            } else {
	                cursor = cursor.right;
	            }
	        }

	        if(cursor != null && cursor.val == val) {
	            return cursor;
	        }
	        return null;
	    }
}
