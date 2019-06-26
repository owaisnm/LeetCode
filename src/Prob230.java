
public class Prob230 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
    int count;
    int kthSmallest = Integer.MAX_VALUE;
    
    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inorder(root);
        return kthSmallest;
    }
    
    public void inorder(TreeNode node) {
        if(node.left !=  null) {
            inorder(node.left);
        }
        count--;
        if(count == 0) {
            kthSmallest = node.val;
        }
        if(node.right != null) {
            inorder(node.right);
        }
    }
}
