import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob39 {
	 public List<List<Integer>> combinationSum(int[] candidates, int target) {
	        
	        Arrays.sort(candidates);
	        return combinationSum(new ArrayList<List<Integer>>(), new ArrayList<Integer>(), candidates, target, 0);
	    }

	    public List<List<Integer>> combinationSum(List<List<Integer>> setOfLists, List<Integer> list, int[] candidates, int target, int start) {
	        
	        if(target == 0) {
	            setOfLists.add(new ArrayList<Integer>(list));
	            return setOfLists;
	        } 
	        
	        for(int i = start; i < candidates.length && candidates[i] <= target; i++) {
	            list.add(candidates[i]);
	            combinationSum(setOfLists, list, candidates, target - candidates[i], i);
	            list.remove(list.size()-1);
	        }
	        
	        return setOfLists;
	    }
}
