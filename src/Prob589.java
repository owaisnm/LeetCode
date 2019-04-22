import java.util.ArrayList;
import java.util.List;

public class Prob589 {
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	 public List<Integer> preorder(Node root) {
	        
	        List<Integer> l = new ArrayList<>();
	        
	        if(root == null) {
	            return l;
	        }
	        preOrder(l, root);
	        return l;
	    }
	    
	    public void preOrder(List<Integer> l, Node r) {
	        l.add(r.val);
	        for(Node n : r.children) {
	            preOrder(l, n);
	        }
	    }
}
