import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Stack;

public class GraphAlgo {
	
	Node head;
	int N;
	
	class Node {
		int val;
		List<Node> vertices;
		boolean visited;
		
		Node(int val) {
			this.val = val;
			vertices = new ArrayList<Node>();
		}
	}

	void createGraph() {
		Node a, b, c, d, e, f, g, h, i, j, k, l;
		a = new Node(0);
		b = new Node(1);
		c = new Node(2);
		d = new Node(3);
		e = new Node(4);
		f = new Node(5);
		g = new Node(6);
		h = new Node(7);
		i = new Node(8);
		j = new Node(9);
		k = new Node(10);
		l = new Node(11);
		
		a.vertices.add(b);
		b.vertices.add(c);
		b.vertices.add(d);
		b.vertices.add(e);
		
		c.vertices.add(f);
		f.vertices.add(g);
		f.vertices.add(h);
//		f.vertices.add(a); // introduce a cycle
		g.vertices.add(i);
		
		d.vertices.add(j);
		j.vertices.add(k);
		j.vertices.add(l);
		j.vertices.add(f);
		N = 12;
		head = a;
	}

	
	boolean[][] createAdjacencyMatrix() {
		createGraph();
		if(head == null) {
			return null;
		}
		
		boolean[][] matrix = new boolean[N][N];
		
		Stack<Node> stack = new Stack<>();
		stack.push(head);
		Node cursor;
		while(!stack.isEmpty()) {
			cursor = stack.pop();
			cursor.visited = true;
			for(Node n: cursor.vertices) {
				matrix[cursor.val][n.val] = true;
				if(!n.visited){
					stack.push(n);	
				}
			}
		}
		
		//print matrix
		for(int i = 0; i< N; i++) {
			for(int j = 0; j < N; j++) { 
				if(matrix[i][j]) {
					System.out.println("("+i+","+j+")" + matrix[i][j]);
				}
			}
		}
		
		return matrix;

	}
	
	 Map<Integer, List<Integer>> createAdjacencyList() {
	 
		 List<Integer> list = null;
		 Map<Integer, List<Integer>> map = new HashMap<>(); 
		 LinkedList<Node> queue = new LinkedList<>();
		 queue.add(head);
		 Node cursor;
		 while(!queue.isEmpty()) {
			 cursor = queue.poll();
			 cursor.visited = true;
			 if(cursor.vertices != null && !cursor.vertices.isEmpty()) {
				 list = new ArrayList<>(); 
			 }
			 for(Node n : cursor.vertices) {
				 list.add(n.val);
				 if(!n.visited) {
					 queue.add(n);
				 }
			 }
			 if(list != null) {
				 map.put(cursor.val, list);
			 }
			 list = null;
		 }
		 
		 
		 // print adjacency list
		 Iterator it = map.entrySet().iterator();
		 while(it.hasNext()) {
			 Map.Entry<Integer, List<Integer>> entry = (Map.Entry<Integer, List<Integer>>) it.next();
			 System.out.print(entry.getKey() +" -> ");
			 for(Integer i : entry.getValue()) {
				 System.out.print(i +", ");
			 }
			 System.out.println();
		 }
		 
		 return map;
	 }

	
	void dfs() {
		createGraph();

		Node tmp;
		Node cursor = head;
		Stack<Node> stack = new Stack<>();
		stack.push(cursor);
		while(!stack.isEmpty()) {
			tmp = stack.pop();
			tmp.visited = true;
			System.out.println(tmp.val + " ");
			for(int i = 0; i < tmp.vertices.size(); i++) {
				if(!tmp.vertices.get(i).visited) {
					stack.push(tmp.vertices.get(i));
				}
			}
		}
	}
	
	void bfs() {
		createGraph();
		
		LinkedList<Node> queue = new LinkedList<>();
		queue.add(head);
		Node cursor;
		while(!queue.isEmpty()) {
			cursor = queue.poll();
			cursor.visited = true;
			System.out.println(cursor.val+" ");
			for(Node n : cursor.vertices) {
				if(!n.visited) {
					queue.add(n);
				}
			}
		}
	}
	
	// topological sort
	List<Integer> topSort() {
		boolean[][] matrix = createAdjacencyMatrix();

		if(matrix == null) {
			return null;
		}
		
		N = matrix.length;

		boolean[] visited = new boolean[N];
		boolean[] recStack = new boolean[N];
		List<Integer> list = new ArrayList<>();
		Stack<Integer> stack = new Stack<>();
		
		for(int i = 0; i < matrix.length; i++) {
			if(topSortRecursive(recStack, visited, matrix, N, stack, i) == -1) {
				System.out.println("topsort unsuccessful - cycle detected!");
				return null;
			}
		}
		
		Iterator<Integer> it = stack.iterator();
		while(it.hasNext()) {
			System.out.print(it.next() +", ");
		}

		return list;
	}
	
	int topSortRecursive(boolean[] recStack, boolean[] visited, boolean[][] matrix,int N, Stack<Integer> stack, int val) {
		System.out.println("recStack: " + val);
		if(recStack[val]) {
			return -1;
		}
		recStack[val] = true;
		for(int i = 0; i < N; i++) {
			if(matrix[val][i] && !visited[i]) {
				if(topSortRecursive(recStack, visited, matrix, N, stack, i) == -1) {
					return -1;
				}
			}
		}
		if(!visited[val]) {
			visited[val] = true;
			stack.push(val);
		}
		recStack[val] = false;
		return 1;
	}
}
