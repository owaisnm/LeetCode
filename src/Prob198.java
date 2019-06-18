
public class Prob198 {
	 int[] result;
	    
	    /* recursive relation:
	        rob(n) = Math.max(rob(n-2) + currentHouseValue, rob(n-1))
	    /*
	    
	    // recursion: (causes time limit exceeded error)
	    /*public int rob(int[] nums, int n) {
	        if(n == 0) {
	            return nums[0];
	        } else if(n == 1) {
	            return Math.max(nums[0], nums[1]);
	        }
	        return Math.max(rob(nums, n-2) + nums[n], rob(nums, n-1));
	    }*/
	    
	    // recursion + memoization:
	    /*public int rob(int[] nums, int n) {
	        if(n == 0) {
	            return nums[0];
	        } else if(n == 1) {
	            return Math.max(nums[0], nums[1]);
	        } else if(result[n] > -1) {
	            return result[n];
	        }
	        result[n] = Math.max(rob(nums, n-2) + nums[n], rob(nums, n-1));
	        return result[n];
	    }*/
	    
	    // iteration + memoization:
	     /*public int rob(int[] nums) {
	        if(nums.length == 0) {
	            return 0;
	        } else if(nums.length == 1) {
	            return nums[0];
	        }
	        result = new int[nums.length];
	        result[0] = nums[0];
	        result[1] = Math.max(nums[0], nums[1]);
	        for(int i = 2; i < nums.length; i++) {
	            result[i] = Math.max(result[i-2] + nums[i], result[i-1]);
	        }
	        return result[nums.length-1];
	    }*/
	    
	    // iteration + N variables 
	    public int rob(int[] nums) {
	        
	        if(nums.length == 0) {
	            return 0;
	        }
	        
	        int prev1 = 0;
	        int prev2 = 0;
	        
	        for(int i = 0; i < nums.length; i++) {
	            int tmp = prev1;
	            prev1 = Math.max(prev2 + nums[i], prev1);
	            prev2 = tmp;
	        }
	        return prev1;
	    }
}
