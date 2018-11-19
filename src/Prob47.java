import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob47 {
	
    public List<List<Integer>> permuteUnique(int[] nums) {
    	
    	List<List<Integer>> solutionList = new ArrayList<List<Integer>>();
    	boolean visited[] = new boolean[nums.length];
    	Arrays.sort(nums);
    	backtrack(solutionList, nums, new ArrayList<>(), visited);
    	return solutionList;
    }
   
    public void backtrack(List<List<Integer>> solutionList, int[] nums, List<Integer> sol, boolean visited[] ) {
    	
    	if(sol.size() == nums.length) {
    		solutionList.add(new ArrayList<>(sol));
    	} else {
	    	for(int i = 0; i < nums.length; i++) {
	    		if(visited[i] || i > 0 && nums[i-1] == nums[i] && !visited[i-1]) {
	    			continue;
	    		}
	    		sol.add(nums[i]);
	    		visited[i] = true;
	    		backtrack(solutionList, nums, sol, visited);
	    		visited[i] = false;
	    		sol.remove(sol.size()-1);
	    	}
    	}
    }
}