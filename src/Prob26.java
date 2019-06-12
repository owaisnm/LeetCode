
public class Prob26 {
	public int removeDuplicates(int[] nums) {        
        int insertAtIndex = 1;
        int i = 1;
        while(i < nums.length) {
            while(i < nums.length && nums[insertAtIndex-1] == nums[i]) {
                i++;
            }
            if(i == nums.length) {
                return insertAtIndex;
            }
            nums[insertAtIndex] = nums[i];
            insertAtIndex++;
        }
        return insertAtIndex++;
    }
}
