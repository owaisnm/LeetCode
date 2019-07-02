import java.util.LinkedList;

public class Prob116 {
	class Node {
	    public int val;
	    public Node left;
	    public Node right;
	    public Node next;

	    public Node() {}

	    public Node(int _val,Node _left,Node _right,Node _next) {
	        val = _val;
	        left = _left;
	        right = _right;
	        next = _next;
	    }
	};
	
	
	  public Node connect(Node root) {
	        if(root == null) {
	            return root;
	        }
	        
	        LinkedList<Node> queue = new LinkedList<>();
	        queue.add(root);
	        
	        Node cursor;
	        int levelTotal = 2;
	        int index = 1;
	        Node left, right;
	        left = right = null;
	        
	        // add all nodes on that level to the queue and set next pointers
	        while(!queue.isEmpty()) {
	            while(index < levelTotal) {
	                cursor = queue.remove();
	                if(cursor.left != null) {
	                    left = cursor.left;
	                    if(right != null) {
	                        right.next = left;
	                    }
	                    queue.add(left);
	                }
	                if(cursor.right != null) {
	                    right = cursor.right;
	                    queue.add(right);
	                    left.next = right;    
	                }
	                index++;
	            }
	            right = null;
	            levelTotal *= 2;
	        }
	        return root;
	    }

}
