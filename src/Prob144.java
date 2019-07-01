import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Prob144 {
	public class TreeNode {
	      int val;
	      TreeNode left;
	      TreeNode right;
	      TreeNode(int x) { val = x; }
	  }
	
	public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) {
            return list;
        }
        // preOrderRecursive(root, list);
        preOrderIterative(root, list);
        return list;
    }
    
    // using recursion
    public void preOrderRecursive(TreeNode root, List<Integer> list) {
        if(root == null ) {
            return;
        } else {
            list.add(root.val);
        }
        preOrderRecursive(root.left, list);
        preOrderRecursive(root.right, list);
    }
    
    // using a stack to implement DFS
    public void preOrderIterative(TreeNode root, List<Integer> list) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode cursor;
        while(!stack.isEmpty()) {
            cursor = stack.pop();
            list.add(cursor.val);
            if(cursor.right != null) {
                stack.add(cursor.right);
            }
            if(cursor.left != null) {
                stack.add(cursor.left);
            }       
        }
    }
}
