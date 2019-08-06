import java.util.Comparator;
import java.util.PriorityQueue;

public class Prob23 {
	   public ListNode mergeKLists(ListNode[] lists) {
	        if(lists == null || lists.length == 0) {
	            return null;
	        } 
	        
	        // solution using priority queue
	        // TC: O(log(m)(n1+n2+...+nk))
	        // where m = length of list of linked lists, nk = length of kth linked list
	        
	        ListNode head, curr;
	        head = curr = null;

	        PriorityQueue<ListNode> pq = new PriorityQueue<ListNode>(lists.length, (Comparator<? super ListNode>) new ListNodeComparator()); 
	        for(int i = 0; i < lists.length; i++) {
	            if(lists[i] != null) {
	                pq.add(lists[i]);
	            }
	        }
	        
	        ListNode node;
	        
	        while(!pq.isEmpty()) {
	            node = pq.poll();
	            if(node == null) {
	                continue;
	            }
	            
	            if(curr == null) {
	                head = new ListNode(node.val);
	                if(node.next != null) {
	                    pq.add(node.next);
	                }
	                curr = head;
	            } else {
	                curr.next = new ListNode(node.val);
	                if(node.next != null) {
	                    pq.add(node.next);
	                }   
	                curr = curr.next;
	            }
	        }
	        
	        return head;
	        
	        // solution without a priority queue
	        // TC: O(m(n1+n2+...+nk))
	        // where m = length of list of linked lists, nk = length of kth linked list
	        
//	         int minIndex = -1;
//	         ListNode head, curr;
//	         head = curr = null;
//	         boolean allNull = true;
	        
//	         for(int i = 0; i < lists.length; i++) {
	            
//	             if(lists[i] != null) {
//	                 allNull = false;
	                
//	                 if(minIndex == -1) {
//	                     minIndex = i;
//	                 } else if(lists[i].val < lists[minIndex].val) {
//	                     minIndex = i;
//	                 }
//	             }
	            
//	             // rerun if not all linked lists are at the end
//	             if(i == lists.length-1 && !allNull) {
//	                 if(head == null) {
//	                     head = new ListNode(lists[minIndex].val);
//	                     curr = head;
//	                 } else {
//	                     curr.next = new ListNode(lists[minIndex].val);
//	                     curr = curr.next;
//	                 }
//	                 lists[minIndex] = lists[minIndex].next;

//	                 i = -1;
//	                 allNull = true;
//	                 minIndex = -1;
//	             }
//	         }
	        
//	         return head;
	    }
	    class ListNodeComparator implements Comparator<ListNode> { 
	            public int compare(ListNode n1, ListNode n2) { 
	                if(n1.val == n2.val) {
	                    return 0;
	                }
	                return n1.val < n2.val ? -1 : 1;
	            } 
	    } 
	    class ListNode {
	    	      int val;
	    	      ListNode next;
	    	      ListNode(int x) { val = x; }
	    	  }
}
