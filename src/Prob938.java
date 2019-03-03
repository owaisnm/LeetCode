
public class Prob938 {
	 public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }

	public int rangeSumBST(TreeNode root, int L, int R) {
	    return rangeSumBST(root, L, R, 0);
	}
	
	int rangeSumBST(TreeNode root, int L, int R, int sum) {
	    if(root == null) {
	        return sum;
	    }
	    return (root.val >= L && root.val <= R ? root.val : 0) 
	        + rangeSumBST(root.left, L, R, 0) 
	        + rangeSumBST(root.right, L, R, 0);
	}
}
