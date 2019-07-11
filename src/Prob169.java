
public class Prob169 {
	 public int majorityElement(int[] nums) {
	        if(nums.length ==1)  {
	            return nums[0];
	        }
	        
	        int count = 1;
	        int majority = nums[0];
	        for(int i = 1; i < nums.length; i++) {
	            if(nums[i] == majority) {
	                count++;
	            } else {
	                if(count > 0) {
	                    count--;
	                }else {
	                    majority = nums[i];
	                        count++;
	                }
	            }
	        }
	        return majority;
	    }
}
