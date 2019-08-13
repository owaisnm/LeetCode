
public class Prob21 {
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1 == null && l2 == null) {
	            return null;
	        }
	        
	        ListNode cursor1 = l1;
	        ListNode cursor2 = l2;
	        ListNode head, cursor, min;
	        
	        if(cursor1 == null) {
	            head = new ListNode(cursor2.val);
	            cursor = head;
	            cursor2 = cursor2.next;
	        } else if(cursor2 == null) {
	            head = new ListNode(cursor1.val);
	            cursor = head;
	            cursor1 = cursor1.next;
	        } else {
	            min = cursor1.val < cursor2.val ? cursor1 : cursor2;
	            head = new ListNode(min.val);
	            cursor = head;
	            if(min.val == cursor1.val) {
	                cursor1 = cursor1.next;
	            } else {
	                cursor2 = cursor2.next;
	            }
	        }
	        
	        while(cursor1 != null && cursor2 != null) {
	            
	            min = cursor1.val < cursor2.val ? cursor1 : cursor2;
	            cursor.next = new ListNode(min.val);
	            cursor = cursor.next;
	            
	            if(min.val == cursor1.val) {
	                cursor1 = cursor1.next;
	            } else {
	                cursor2 = cursor2.next;
	            }
	        }
	        
	        while(cursor1 != null) {
	            cursor.next = new ListNode(cursor1.val);
	            cursor = cursor.next;
	            cursor1 = cursor1.next;
	        } 
	        while(cursor2 != null) {
	            cursor.next = new ListNode(cursor2.val);
	            cursor = cursor.next;
	            cursor2 = cursor2.next;
	        } 
	        return head;
	    }
	 
	 	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
}
