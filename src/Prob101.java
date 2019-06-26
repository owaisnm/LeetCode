import java.util.LinkedList;

public class Prob101 {
	 public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	// T: O(n)
    // S: O(n)
    public boolean isSymmetric(TreeNode root) {  
        if(root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        LinkedList<TreeNode> cache1 = new LinkedList<TreeNode>();
        LinkedList<TreeNode> cache2 = new LinkedList<TreeNode>();
        queue.add(root.left);
        cache1.add(root.left);
        TreeNode cursor;
        while(!queue.isEmpty()) {
            cursor = queue.remove();
            if(cursor != null) {
                queue.add(cursor.left);
                cache1.add(cursor.left);
                queue.add(cursor.right);
                cache1.add(cursor.right);
            }
        }
        
        queue.add(root.right);
        cache2.add(root.right);
        while(!queue.isEmpty()) {
            cursor = queue.remove();
            if(cursor != null) {
                queue.add(cursor.right);
                cache2.add(cursor.right);
                queue.add(cursor.left);
                cache2.add(cursor.left);
            }
        }
        
        TreeNode cursor1, cursor2;
        while(!cache1.isEmpty() && !cache2.isEmpty()) {
            cursor1 = cache1.remove();
            cursor2 = cache2.remove();
            if(cursor1 == null && cursor2 == null || (cursor1 != null && cursor2 != null && cursor1.val == cursor2.val)) {    
            } else {
                return false;
            }
        }
        return cache1.isEmpty() && cache2.isEmpty();
    }
}
