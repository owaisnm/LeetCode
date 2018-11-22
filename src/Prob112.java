public class Prob112 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean hasPathSum(TreeNode root, int sum) {
		return computeSum(root, sum, 0);
	}

	public boolean computeSum(TreeNode root, int sum, int currentSum) {
		if (root == null) {
			return false;
		}
		currentSum += root.val;
		if (root.left == null && root.right == null && currentSum == sum) {
			return true;
		}
		return computeSum(root.left, sum, currentSum) || computeSum(root.right, sum, currentSum);
	}
}
