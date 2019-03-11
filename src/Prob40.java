import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Prob40 {
	   public List<List<Integer>> combinationSum2(int[] candidates, int target) {
 	        Arrays.sort(candidates);
	        return combinationSum2(new ArrayList<List<Integer>>(), new ArrayList<Integer>(), candidates, target, 0);
	    }

 	    public List<List<Integer>> combinationSum2(List<List<Integer>> lists, List<Integer> list, int[] candidates, int target, int start) {

 	        if(target == 0) {
	            lists.add(new ArrayList<Integer>(list));
	            return lists;
	        } 

            int i = start;
 	        while(i < candidates.length && candidates[i] <= target) {
                if(i > start && candidates[i-1] == candidates[i]) {
                    i++;
                    continue;
                }
	            list.add(candidates[i]);
	            combinationSum2(lists, list, candidates, target - candidates[i], i+1);
	            list.remove(list.size()-1);
                i++;
	        }

 	        return lists;
	    }
}
