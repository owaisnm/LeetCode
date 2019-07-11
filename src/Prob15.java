import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Prob15 {
	public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> listOfLists = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        
        int left, right, oldVal, sum, i;
        i = 0;
        while( i < nums.length - 2 && nums[i] <= 0) {
            left = i+1;
            right = nums.length-1;
            
            while(left < right) {
                sum = nums[left] + nums[i] + nums[right];
                if(sum == 0) {
                    listOfLists.add(Arrays.stream(new int[]{nums[left], nums[i], nums[right]}).boxed().collect(Collectors.toList()));
                } 
                if(sum >= 0) {
                    oldVal = nums[right];
                    while(right > left && oldVal == nums[right]) right--;
                } 
                if(sum <= 0) {
                    oldVal = nums[left];
                    while(left < right && oldVal == nums[left]) left++;
                }
            }
            oldVal = nums[i];
            while(i < nums.length-2 && oldVal == nums[i]) i++;
        }
        return listOfLists;
    }
}
