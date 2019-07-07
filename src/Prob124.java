
public class Prob124 {
	
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	int max = Integer.MIN_VALUE;
    
    public int maxPathSum(TreeNode root) {
        maxPathSum2(root);
        return max;
    }
    
    int maxPathSum2(TreeNode root) {
        int left = root.val + (root.left != null ? maxPathSum2(root.left) : 0);
        int right = root.val + (root.right != null ? maxPathSum2(root.right) : 0);
        int both = left + right - root.val;
    
        int localMax = Math.max(root.val, Math.max(left, right));

        if(Math.max(both, localMax) > max) {
            max = Math.max(both, localMax);
        }
        return localMax;
    }
}
