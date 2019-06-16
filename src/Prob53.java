
public class Prob53 {
	 public int maxSubArray(int[] nums) {
	        int tmpMax = nums[0];
	        int max = nums[0];
	        for(int i = 1; i < nums.length; i++) {
	            tmpMax = Math.max(tmpMax + nums[i], nums[i]);
	            max = Math.max(max, tmpMax);
	        }
	        return max;
	    }
}
