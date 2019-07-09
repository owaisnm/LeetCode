import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class GraphAlgo {
	
	class Node {
		int val;
		List<Node> vertices;
		boolean visited;
		
		Node(int val) {
			this.val = val;
			vertices = new ArrayList<Node>();
		}
	}

	void dfs() {
		Node a, b, c, d, e;
		a = new Node(1);
		b = new Node(2);
		c = new Node(3);
		d = new Node(4);
		e = new Node(5);
		
		a.vertices.add(b);
		a.vertices.add(d);
		a.vertices.add(e);
		
		b.vertices.add(a);
		b.vertices.add(c);
		
		c.vertices.add(b);
		c.vertices.add(d);
		
		d.vertices.add(a);
		d.vertices.add(e);
		d.vertices.add(c);
		
		e.vertices.add(a);
		e.vertices.add(d);
		
		Stack<Node> stack = new Stack<>();
		stack.push(a);
		a.visited = true;
		Node cursor;
		while(!stack.isEmpty()) {
			cursor = stack.pop();
			System.out.println(cursor.val);
			for(Node n : cursor.vertices) {
				if(!n.visited) {
					stack.push(n);
					n.visited = true;
				}
			}
		}
	}
	
	void bfs() {
		Node a, b, c, d, e;
		a = new Node(1);
		b = new Node(2);
		c = new Node(3);
		d = new Node(4);
		e = new Node(5);
		
		a.vertices.add(b);
		a.vertices.add(d);
		a.vertices.add(e);
		
		b.vertices.add(a);
		b.vertices.add(c);
		
		c.vertices.add(b);
		c.vertices.add(d);
		
		d.vertices.add(a);
		d.vertices.add(e);
		d.vertices.add(c);
		
		e.vertices.add(a);
		e.vertices.add(d);
		
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(a);
		a.visited = true;
		Node cursor;
		while(!queue.isEmpty()) {
			cursor = queue.remove();
			System.out.println(cursor.val);
			for(Node n : cursor.vertices) {
				if(!n.visited) {
					queue.add(n);
					n.visited = true;
				}
			}
		}
	}
	
}
