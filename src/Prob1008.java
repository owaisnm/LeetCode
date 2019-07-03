import java.util.Stack;

public class Prob1008 {
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	// iterative
	/*public TreeNode bstFromPreorder(int[] preorder) {
        if(preorder == null || preorder.length == 0) {
            return null;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        int i = 0;
        TreeNode root = new TreeNode(preorder[i++]);
        TreeNode cursor = root;
        TreeNode peek = null;
        
        while(i < preorder.length) {
            if(preorder[i] < cursor.val) {
                cursor.left = new TreeNode(preorder[i++]);
                stack.push(cursor);
                cursor = cursor.left;
            } else {
                if(stack.isEmpty()) {
                    cursor.right = new TreeNode(preorder[i++]);
                    cursor = cursor.right;
                } else {
                    peek = stack.peek();
                    if(stack.isEmpty() || preorder[i] < peek.val) {
                        cursor.right = new TreeNode(preorder[i++]);
                        cursor = cursor.right;
                    } else {
                        cursor = stack.pop();
                    }
                }
            }
        }
        return root;
    }*/
	
	// recursive
    int i = 0;
    public TreeNode bstFromPreorder(int[] preorder) {
        return bstFromPreorder(preorder, Integer.MAX_VALUE);
    }
    
    public TreeNode bstFromPreorder(int[] preorder, int val) {
        if(i >= preorder.length || preorder[i] > val) {
            return null;
        }
        
        TreeNode root = new TreeNode(preorder[i++]);
        root.left = bstFromPreorder(preorder, root.val);
        root.right = bstFromPreorder(preorder, val);
        return root;
    }
}
