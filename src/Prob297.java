import java.util.LinkedList;

public class Prob297 {
	
	public class TreeNode {
		      int val;
		      TreeNode left;
		      TreeNode right;
		      TreeNode(int x) { val = x; }
		  }
	
	// Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null) {
            return sb.toString();
        }
        preOrder(sb, root);
        return sb.delete(sb.length()-1, sb.length()).toString();
    }
    
    void preOrder(StringBuilder sb, TreeNode root) {
        if(root == null) {
            sb.append("n").append(",");
            return;
        }
        sb.append(root.val).append(",");
        preOrder(sb, root.left);
        preOrder(sb, root.right);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.length() == 0) {
            return null;
        }
        
        LinkedList<String> queue = new LinkedList<>(Arrays.asList(data.split(",")));
        String s = queue.remove();
        TreeNode root = new TreeNode(Integer.parseInt(s));
        create(queue, root);
        return root;
    }    
    
    public void create(LinkedList<String> queue, TreeNode cursor) {
        String s = queue.remove();
        if(s.equals("n")) {
            cursor.left = null;
        } else  {
            cursor.left = new TreeNode(Integer.parseInt(s));
            create(queue, cursor.left);
        }
            
        
        s = queue.remove();
        if(s.equals("n")) {
            cursor.right = null;
        } else  {
            cursor.right = new TreeNode(Integer.parseInt(s));
            create(queue, cursor.right);
        }
    }
}
