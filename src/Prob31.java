
public class Prob31 {
	public void nextPermutation(int[] nums) {
        if(nums == null || nums.length == 1) {
            return;
        } 
        
        int i = nums.length - 2;
        while(i > -1 && nums[i] >= nums[i+1]) {
            i--;
        }
        if(i > -1) {
            int j = nums.length - 1;
            int tmp;
            while(nums[j] <= nums[i])
                j--;
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            
            reverse(nums, i+1, nums.length - 1);
        } else {
            reverse(nums, 0, nums.length-1);
        }
    }
    
    private void reverse(int[] nums, int start, int end) {
        int i = start;
        int j = end;
        int tmp;
        while(i < j) {
            tmp = nums[i];
            nums[i] = nums[j];
            nums[j] = tmp;
            i++;
            j--;
        }
    }
}
