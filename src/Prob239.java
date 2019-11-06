import java.util.LinkedList;

public class Prob239 {
	 public int[] maxSlidingWindow(int[] nums, int k) {
	        if(nums == null || nums.length == 0 || k == 0) {
	            return new int[0];
	        }
	        int result[] = new int[nums.length - k + 1];
	        LinkedList<Integer> dequeue = new LinkedList<Integer>();
	        for(int i = 0; i < nums.length; i++) {
	            if(!dequeue.isEmpty() && dequeue.peek() < i - k + 1) 
	            	dequeue.poll();
	            
	            while(!dequeue.isEmpty() && nums[dequeue.peekLast()] < nums[i])
	            	dequeue.pollLast();
	            
	            dequeue.offer(i);
	            
	            if(i - k + 1 >= 0) {
	                result[i - k + 1] = nums[dequeue.peek()];
	            }
	        }
	        return result;
	    }
}
