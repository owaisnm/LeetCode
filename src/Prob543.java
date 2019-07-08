
public class Prob543 {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	int max = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) {
            return max;
        }
        diameterOfBinaryTree2(root);
        return max;
    }
    
    public int diameterOfBinaryTree2(TreeNode root) {
        int left, right;
        left = right = 0;
        if(root.left != null) {
            left = 1 + diameterOfBinaryTree2(root.left);
        }
        if(root.right != null) {
            right = 1 + diameterOfBinaryTree2(root.right);
        }
        max = Math.max(max, Math.max(left + right, Math.max(left, right)));
        return Math.max(left, right);
    }
}
