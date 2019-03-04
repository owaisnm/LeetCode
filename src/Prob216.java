import java.util.ArrayList;
import java.util.List;

public class Prob216 {
	  public List<List<Integer>> combinationSum3(int k, int n) {
	        return combinationSum(k, n, 1, 0, new ArrayList<List<Integer>>(), new ArrayList<Integer>());
	    }
	    
	    List<List<Integer>> combinationSum(int k, int n, int currentNum, int currentSum, List<List<Integer>> llist, List<Integer> list) {
	        
	        if(k == list.size()) {
	            if(currentSum == n) {
	                llist.add(list);
	            }
	            return llist;
	        }
	    
	        for(int i = currentNum; i <= 9 && currentSum < n; i++) {
	            List<Integer> newList = new ArrayList<Integer>(list);
	            newList.add(i);
	            combinationSum(k, n, i+1, currentSum + i, llist, newList);
	        }
	        
	        return llist;
	    }
	    
}
