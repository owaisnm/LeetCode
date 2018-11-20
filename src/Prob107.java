import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Prob107 {
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		int level;

		TreeNode(int x) {
			val = x;
		}
	}

	public List<List<Integer>> levelOrderBottom(TreeNode root) {

		LinkedHashMap<Integer, List<Integer>> map = new LinkedHashMap<>();
		if (root != null) {
			traverse(map, root, 0);
		}

		Iterator<Map.Entry<Integer, List<Integer>>> it = map.entrySet().iterator();
		List<List<Integer>> lists = new ArrayList<List<Integer>>();
		while (it.hasNext()) {
			lists.add(0, it.next().getValue());
		}
		return lists;
	}

	public void traverse(LinkedHashMap<Integer, List<Integer>> map, TreeNode root, int level) {
		List<Integer> list;
		if (map.containsKey(level)) {
			list = map.get(level);
		} else {
			list = new ArrayList<Integer>();
		}
		list.add(root.val);
		map.put(level, list);
		if (root.left != null) {
			traverse(map, root.left, level + 1);
		}
		if (root.right != null) {
			traverse(map, root.right, level + 1);
		}
	}

}
