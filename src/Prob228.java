import java.util.ArrayList;
import java.util.List;

public class Prob228 {
	public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();
        if(nums == null || nums.length == 0) {
            return ranges;
        }
        
        int low, high;
        low = high = 0;
        boolean lowSet, highSet;
        lowSet = highSet = false;
        
        for(int i = 0; i < nums.length-1; i++) {
            if(nums[i] + 1 == nums[i+1]) {
                if(!lowSet) {
                    low = nums[i];
                    high = nums[i+1];
                    lowSet = true;
                    highSet = true;
                } else {
                    high = nums[i+1];
                }
            } else {
                if(!highSet) {
                    ranges.add(String.valueOf(nums[i]));
                } else {
                    ranges.add(String.valueOf(low) + "->" + String.valueOf(high));
                }
                lowSet = false;
                highSet = false;
            }
        }
        
        if(!highSet) {
            ranges.add(String.valueOf(nums[nums.length-1]));
        } else {
            ranges.add(String.valueOf(low) + "->" + String.valueOf(high));
        }
        return ranges;
    }
}
