
public class Prob674 {
	 public int findLengthOfLCIS(int[] nums) {
        int thisCount, longestCount;
        thisCount = 1;
        longestCount = 0;
        
        if(nums == null || nums.length == 0) {
            return 0;
        }
        
        for(int i = 0; i < nums.length - 1; i++) {
            if(nums[i] < nums[i+1]) {
                thisCount++;
            } else {
                if(thisCount > longestCount) {
                    longestCount = thisCount;
                }
                thisCount = 1;   
            }
        }
         if(thisCount > longestCount) {
                    longestCount = thisCount;
         }
        return longestCount;
    }
}
