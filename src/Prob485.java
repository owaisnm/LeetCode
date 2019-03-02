
public class Prob485 {
  public int findMaxConsecutiveOnes(int[] nums) {
        int thisMax, max;
        thisMax = max = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                thisMax++;
            } else{
                if(thisMax > max) {
                    max = thisMax;
                }
                thisMax = 0;
            }
        }
        if(thisMax > max) {
            max = thisMax;
        }
        return max;
    }
}
