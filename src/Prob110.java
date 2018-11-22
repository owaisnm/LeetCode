
public class Prob110 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public boolean isBalanced(TreeNode root) {
		if (root == null) {
			return true;
		}
		return height(root) != -1;
	}

	public int height(TreeNode root) {

		if (root == null) {
			return 0;
		}

		int l = height(root.left);
		if (l == -1) {
			return -1;
		}
		l++;

		int r = height(root.right);
		if (r == -1) {
			return -1;
		}
		r++;

		if (Math.abs(l - r) > 1) {
			return -1;
		}
		return l > r ? l : r;
	}
}
