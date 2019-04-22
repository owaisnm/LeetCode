import java.util.ArrayList;
import java.util.List;

public class Prob590 {
	class Node {
	    public int val;
	    public List<Node> children;

	    public Node() {}

	    public Node(int _val,List<Node> _children) {
	        val = _val;
	        children = _children;
	    }
	}
	 public List<Integer> postorder(Node root) {

	        List<Integer> l = new ArrayList<>();

	        if(root == null) {
	            return l;
	        }
	        postorder(l, root);
	        return l;
	    }

	    public void postorder(List<Integer> l, Node r) {
	        for(Node n : r.children) {
	            postorder(l, n);
	        }
	        l.add(r.val);
	    }
}
