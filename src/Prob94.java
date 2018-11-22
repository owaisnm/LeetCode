import java.util.ArrayList;
import java.util.List;

public class Prob94 {

	public class TreeNode {
		int val;
		public TreeNode left;
		public TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<Integer> inorderTraversal(TreeNode root) {
		List<Integer> values = new ArrayList<>();
		if (root != null) {
			inorder(values, root);
		}
		System.out.println(values);
		return values;
	}

	void inorder(List<Integer> values, TreeNode node) {
		if (node.left != null) {
			inorder(values, node.left);
		}
		values.add(node.val);
		if (node.right != null) {
			inorder(values, node.right);
		}
	}
}
