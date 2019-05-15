import java.util.ArrayList;
import java.util.List;

public class Prob739 {
	public int[] dailyTemperatures(int[] T) {
        int[] output = new int[T.length];
        List<List<Integer>> store = new ArrayList<List<Integer>>();
        for(int i = 0; i < 101; i++) {
            store.add(new ArrayList<Integer>());
        }
        
        for(int i = 0; i < T.length; i++) {
            List<Integer> indices = store.get(T[i]);
            indices.add(i);
            
            for(int j = 30; j < T[i]; j++) {
                List<Integer> check = store.get(j);
                while(check.size() > 0) {
                    output[check.get(0)] = i - check.get(0);
                    check.remove(0);
                }
            }
        }
        return output;
}
