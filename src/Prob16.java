
public class Prob16 {
	
	// brute force 
	// time: T(n) = O(n^3)
	// space: S(n) = O(1)
	public int threeSumClosest(int[] nums, int target) {
        int closest = Integer.MAX_VALUE - target;
        int closestToZero = Integer.MAX_VALUE;
        int x, y, z;
        for(int i = 0; i < nums.length - 2; i++) {
            for(int j = i+1; j < nums.length - 1; j++) {
                for(int k = j+1; k < nums.length; k++) {
                    if(Math.abs( (nums[i] + nums[j] + nums[k] - target)) < closestToZero) {
                        closestToZero = Math.abs(nums[i] + nums[j] + nums[k] - target);
                        closest = nums[i] + nums[j] + nums[k];
                    }
                }
            }
        }
        return closest;
    }
}
