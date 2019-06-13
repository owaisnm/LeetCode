
public class ReverseLinkedList {
	class Node {
		int val;
		Node next;
		Node(int val, Node next){
			this.val = val;
			this.next = next;
		}
	}
	
	
	public Node generateList() {
		Node n5 = new Node(5, null);
		Node n4 = new Node(4, n5);
		Node n3 = new Node(3, n4);
		Node n2 = new Node(2, n3);
		Node n1 = new Node(1, n2);
		return n1;
	}
	
	public Node reverseLinkedList(Node head) {
		
		/*
		 *   1 -> 2 -> 3 -> 4 -> 5 -> null
		 *   null <- 1 <- 2 <- 3 <- 4 <- 5 
		 */
		
		Node curr, prev, next;
		prev = next = null;
		curr = head;
		
		while(curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		head = prev;
		return head;
	}
	
	public void printAllNodes(Node head) {
		Node cursor = head;
		while(cursor != null) {
			System.out.print(cursor.val + " ");
			cursor = cursor.next;
		}
	}
}
