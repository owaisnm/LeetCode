
public class Prob98 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	
	
	public boolean isValidBST(TreeNode root) {    
        if(root == null) {
            return true;
        }
        
        //recursive
        return isValidBST(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean isValidBST(TreeNode root, long minBound, long maxBound) {
        boolean valid = (root != null ? (minBound < (long) root.val && (long) root.val < maxBound) : true);
        return valid && (root.left != null ? isValidBST(root.left, minBound, (long)root.val) : true) && (root.right != null ? isValidBST(root.right,(long) root.val, maxBound) : true);
    } 
}
