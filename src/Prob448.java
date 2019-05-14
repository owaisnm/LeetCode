import java.util.ArrayList;
import java.util.List;

public class Prob448 {
	public List<Integer> findDisappearedNumbers(int[] nums) {
        for(int i = 0; i < nums.length; i++) {
            int ind = Math.abs(nums[i]);
            if(nums[ind-1] > 0) {
                nums[ind-1] = -1 * nums[ind-1];
            }
        }
        
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }
}
