
public class Prob654 {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	 
	public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructMaximumBinaryTree(nums, 0, nums.length-1);
    }
    
    TreeNode constructMaximumBinaryTree(int[] nums, int l, int r) { 
        int maxNum = nums[l];
        int maxIndex = l;
        for(int i = l; i <= r; i++) {
            if(nums[i] > maxNum) {
                maxNum = nums[i];
                maxIndex = i;
            }
        }
        
        TreeNode node = new TreeNode(maxNum);
        if(l <= maxIndex - 1) {
            node.left = constructMaximumBinaryTree(nums, l, maxIndex - 1);
        }
        if(maxIndex + 1 <= r) {
            node.right = constructMaximumBinaryTree(nums, maxIndex + 1, r);
        }
        return node;
    }
}
