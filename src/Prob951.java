
public class Prob951 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if(!equals(root1, root2)) {
            return false;
        }
        return flip(root1, root2);
    }
    
    public boolean flip(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 == null) {
            return true;
        }
        
        TreeNode tmp;
        boolean left, right;
        if(equals(root1.left, root2.left) && equals(root1.right, root2.right)) {
            left = flip(root1.left, root2.left);
            right = flip(root1.right, root2.right);
            return left && right;
        } else if(equals(root1.left, root2.right) && equals(root1.right, root2.left)) {
            // flip root2's left and right subtrees
            tmp = root2.left;
            root2.left = root2.right;
            root2.right = tmp;
            // continue recursion
            left = flip(root1.left, root2.left);
            right = flip(root1.right, root2.right);
            return left && right;
        } 
        return false;
    }
    
    boolean equals(TreeNode root1, TreeNode root2) {
        if(root1 == null && root2 != null)  {
            return false;
        } else if(root2 == null && root1 != null) {
            return false;
        } else if(root1 == null && root2 == null) {
            return true;
        } else {
            return root1.val == root2.val;
        }
    }
}
