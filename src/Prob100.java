import java.util.LinkedList;
import java.util.Queue;

public class Prob100 {

	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	/*
	 * method: iterative
	 * time: O(n): n
	 * space: O(n): n
	 */
	public boolean isSameTree(TreeNode p, TreeNode q) {

		if (p == null || q == null) {
			return p == null && q == null;
		}

		TreeNode current1, current2;
		Queue<TreeNode> q1 = new LinkedList<>();
		Queue<TreeNode> q2 = new LinkedList<>();
		q1.add(p);
		q2.add(q);
		while (!q1.isEmpty() && !q2.isEmpty()) {
			current1 = q1.remove();
			current2 = q2.remove();
			if (!isValEqual(current1, current2)) {
				return false;
			}
			if (current1 == null) {
				continue;
			}
			q1.add(current1.left);
			q2.add(current2.left);

			q1.add(current1.right);
			q2.add(current2.right);

		}
		return q1.isEmpty() && q2.isEmpty();
	}

	public boolean isValEqual(TreeNode n1, TreeNode n2) {
		if (n1 == null || n2 == null) {
			return n1 == null && n2 == null;
		}

		return n1.val == n2.val;
	}
}
