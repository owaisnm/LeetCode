
public class Prob235 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode curr = root;
        int min, max;
        min = Math.min(p.val, q.val);
        max = Math.max(p.val, q.val);
        
        while(curr.val > max || curr.val < min) {
            if(curr.val > max) {
                curr = curr.left;
            } else if(curr.val < min) {
                curr = curr.right;
            } else {
                return curr;
            }
        }
        return curr;
    }
}
