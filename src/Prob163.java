import java.util.ArrayList;
import java.util.List;

public class Prob163 {
	public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int index = 0; 
        long i = lower;
        long missingStart;
        
        List<String> list = new ArrayList<>();

        if(nums.length == 0) {
            if(lower == upper) {
                list.add(String.valueOf(lower));
            } else {
                list.add(String.valueOf(lower)+"->"+String.valueOf(upper));
            }
            return list;
        }
        
        if(i < nums[index]) {
            missingStart = i;
            if(i < nums[index]) {
                i = (long) nums[index];
            }
            
            if(missingStart == i - 1) {
                list.add(String.valueOf(missingStart));
            } else {
                list.add(String.valueOf(missingStart)+"->"+(i-1));
            }
            i++;
            index++;
        }
        
        while(index < nums.length && i <= upper) {
            if(i < nums[index]) {
                missingStart = i;
                if(i < nums[index]) {
                    i = (long) nums[index];
                }

                // equal now
                if(missingStart ==  i - 1) {
                    list.add(String.valueOf(missingStart));
                } else {
                    list.add(String.valueOf(missingStart)+"->"+(i-1));
                }
                i++;
                index++;
            }  else if(i == nums[index]) {
                i++;
                index++;
            } else {
                index++;
            }
        }
        
        index--;
        if(nums[index] < upper) {
            missingStart = nums[index] + 1;
            if(i < upper) {
                i = upper;
            }
            
            // equal now
            if(missingStart == i) {
                list.add(String.valueOf(missingStart));
            } else {
                list.add(String.valueOf(missingStart)+"->"+i);
            }
            i++;
            index++;
        }
        return list;
    }
}
