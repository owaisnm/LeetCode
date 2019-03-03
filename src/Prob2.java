
public class Prob2 {
	public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
		  }
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode cursor = null;
        boolean carry = false;
        int val;
        while(l1 != null || l2 != null || carry) {
            val = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            if(carry) val++;
            carry = val > 9;
            val = val % 10;
            
            if(cursor == null)  {
                cursor = new ListNode(val);
                head = cursor;
            }
            else {
                cursor.next = new ListNode(val);
                cursor = cursor.next;
            }
            
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        return head;
    }
}
