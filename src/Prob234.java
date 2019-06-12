import java.util.ArrayList;
import java.util.List;

public class Prob234 {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
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
}
