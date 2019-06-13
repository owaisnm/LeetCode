import java.util.ArrayList;
import java.util.List;

public class Prob234 {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }

	// space: O(n), time: O(n)
	  public boolean isPalindrome(ListNode head) {
	        List<Integer> list = new ArrayList<>();
	        ListNode cursor = head;
	        while(cursor != null) {
	            list.add(cursor.val);
	            cursor = cursor.next;
	        }
	        
	        for(int i = 0; i < list.size() / 2; i++) {
	            
	            if(list.get(i).intValue() != list.get(list.size() - 1 - i).intValue()) {
	                return false;
	            }
	        }
	        return true;
	    }
	  
	// space: O(1), time: O(n)
	  public boolean isPalindromeOptimal(ListNode head) {
	        if( head == null || head.next == null) {
	            return true;
	        }
	            
	        // identify halfway
	        ListNode slowCursor, fastCursor;
	        slowCursor = head;
	        fastCursor = head.next;
	        while(fastCursor.next != null && fastCursor.next.next != null) {
	            slowCursor = slowCursor.next;
	            fastCursor = fastCursor.next.next;
	        }
	        if(fastCursor.next != null) {
	            slowCursor = slowCursor.next;
	            fastCursor = fastCursor.next;
	        }
	        
	        // reverse 2nd half
	        ListNode curr, next, prev;
	        curr = slowCursor;
	        prev = next = null;
	        while(curr != null) {
	            next = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = next;
	        }
	        
	        // prev is now the last node
	        // we need curr to be the first
	        curr = head;
	        while(curr != null) {
	            if(curr.val != prev.val) {
	                return false;
	            } 
	            curr = curr.next;
	            prev = prev.next;
	        }
	        return true;
	    } 
	 
}
