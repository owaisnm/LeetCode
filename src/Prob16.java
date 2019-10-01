import java.util.Arrays;

public class Prob16 {
	
	// use 3sum technique
	public int threeSumClosest(int[] nums, int target) {
		int minDiff = Integer.MAX_VALUE;
        int minSum = Integer.MAX_VALUE;
        int diff;
        int sum;
        int i, left, right;
        i = 0;
        
        Arrays.sort(nums);
        while(i < nums.length - 2) {
            left = i+1;
            right = nums.length - 1;
            while(left < right) {
                sum = nums[i] + nums[left] + nums[right];
                diff = Math.abs(sum - target);
                if(diff < minDiff) {
                    minDiff = diff;
                    minSum = sum;
                    if(minDiff == 0) {
                        return minSum;
                    }
                }
                if(sum < target) {
                    left++;
                    while(left < right && nums[left-1] == nums[left])
                       left++;
                } else {
                    right--;
                    while(left < right && nums[right] == nums[right+1])
                        right--;
                }
            }
            i++;
            while(i < nums.length - 2 && nums[i-1] == nums[i]) 
                i++;
        }
        return minSum;
    }
}
