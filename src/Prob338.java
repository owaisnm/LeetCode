import java.util.ArrayList;
import java.util.List;

public class Prob338 {
	 public int[] countBits(int num) {
	        List<Integer> result = new ArrayList<>();
	        result.add(0);
	        if(num == 0) {
	            return getIntArray(result);
	        }
	        result.add(1);
	        if(num == 1) {
	            return getIntArray(result);
	        }
	        for(int i = 2; i <= num; i++) {
	            result.add(result.get(i%2) + result.get(i/2));
	        }
	        return getIntArray(result);
	    }
	    
	    int[] getIntArray(List<Integer> result) {
	        return result.stream()
								.mapToInt(Integer::intValue)
								.toArray();
	    }
}
