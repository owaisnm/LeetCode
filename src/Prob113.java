import java.util.ArrayList;
import java.util.List;

public class Prob113 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> pathSum(TreeNode root, int sum) {
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		if (root == null) {
			return lists;
		}
		computeSum(lists, new ArrayList<Integer>(), root, sum, 0);
		return lists;
	}

	public void computeSum(List<List<Integer>> lists, List<Integer> list, TreeNode root, int sum, int currentSum) {
		list.add(root.val);
		currentSum += root.val;
		if (root.left == null && root.right == null && currentSum == sum) {
			lists.add(new ArrayList<Integer>(list));
			return;
		}
		if (root.left != null) {
			computeSum(lists, list, root.left, sum, currentSum);
			list.remove(list.size() - 1);
		}
		if (root.right != null) {
			computeSum(lists, list, root.right, sum, currentSum);
			list.remove(list.size() - 1);
		}
	}
}
