public class Prob617 {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {

        TreeNode t0 = null;
        if(t1 == null && t2 == null) {
            return t0;
        }
        t0 = new TreeNode(0);
        merge(t0, t1, t2);
        return t0;
    }
    
    public void merge(TreeNode t0, TreeNode t1, TreeNode t2) {
        int sum = 0;
        if(t1 != null) {
            sum += t1.val;
        } 
        if(t2 != null) {
            sum += t2.val;
        }
        t0.val = sum;

        if((t1 != null && t1.left != null) || (t2 != null && t2.left != null)) {
            t0.left = new TreeNode(0);
            merge(t0.left, t1 != null ? t1.left : null, t2 != null ? t2.left : null);
        }
        if((t1 != null && t1.right != null) || (t2 != null && t2.right != null)) {
            t0.right = new TreeNode(0);
            merge(t0.right,  t1 != null ? t1.right : null, t2 != null ? t2.right : null);
        }
    }

}
