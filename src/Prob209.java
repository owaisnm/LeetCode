
public class Prob209 {
	public int minSubArrayLen(int s, int[] nums) {
        int start, end;
        start = end = 0;
        int minLength = Integer.MAX_VALUE;
        int sum = 0;
        
        while(end < nums.length) {
            sum += nums[end];
            while(start <= end && sum >= s) {
                if(end + 1 - start < minLength) {
                    minLength = end + 1 - start;
                }
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return minLength != Integer.MAX_VALUE ? minLength : 0;
    }
}
