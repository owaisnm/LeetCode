
public class Prob283 {
	  public void moveZeroes(int[] nums) { 
	        int[] nextIndices = new int[] {0, 0};
	        if(!setNextIndices(nums, 0, nextIndices)) {
	            return;
	        }
	        
	        while(nextIndices[1] < nums.length) {
	            nums[nextIndices[0]] = nums[nextIndices[1]];
	            nums[nextIndices[1]] = 0;
	            if(!setNextIndices(nums, nextIndices[0]+1, nextIndices)) {
	                return;
	            }
	        }        
	    }
	    
	    private boolean setNextIndices(int nums[], int curr, int[] nextIndices) {
	        boolean nextZeroSet, nextNonZeroSet;
	        nextZeroSet = nextNonZeroSet = false;
	        
	        for(int i = curr; i < nums.length; i++) {
	            if(nums[i] == 0 && !nextZeroSet) {
	                nextIndices[0] = i;
	                nextZeroSet = true;
	            } else if(nums[i] != 0 && nextZeroSet && !nextNonZeroSet) {
	                nextIndices[1] = i;
	                nextNonZeroSet = true;
	            } 
	            if(nextZeroSet && nextNonZeroSet ){
	                break;
	            }
	        }
	        return nextZeroSet && nextNonZeroSet;
	    }

}
