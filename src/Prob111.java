
public class Prob111 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public int minDepth(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int h = 1;
		return minHeight(root, h);
	}

	public int minHeight(TreeNode root, int h) {

		if (root.left == null && root.right == null) {
			return h;
		}

		int lH = 0;
		int rH = 0;
		if (root.left != null) {
			lH = minHeight(root.left, h + 1);
		}
		if (root.right != null) {
			rH = minHeight(root.right, h + 1);
		}

		if (lH == 0) {
			return rH;
		} else if (rH == 0) {
			return lH;
		} else {
			return lH < rH ? lH : rH;
		}
	}
}
