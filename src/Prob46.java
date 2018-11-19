import java.util.ArrayList;
import java.util.List;

public class Prob46 {

    public List<List<Integer>> permute(int[] nums) {
    	
    	List<List<Integer>> solutionList = new ArrayList<List<Integer>>();
    	backtrack(solutionList, nums, new ArrayList<>());
    	return solutionList;
    }
   
    public void backtrack(List<List<Integer>> solutionList, int[] nums, List<Integer> sol) {
    	
    	if(sol.size() == nums.length) {
    		solutionList.add(new ArrayList<>(sol));
    	} else {
	    	for(int i = 0; i < nums.length; i++) {
	    		if(sol.contains(nums[i])) {
	    			continue;
	    		}
	    		sol.add(nums[i]);
	    		backtrack(solutionList, nums, sol);
	    		sol.remove(sol.size()-1);
	    	}
    	}
    }
}