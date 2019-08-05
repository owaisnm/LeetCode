import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Prob56 {
	public int[][] merge(int[][] intervals) {
        if(intervals.length < 2) {
            return intervals;
        }

        // sort intervals
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                }
                return o1[0] - o2[0];
            }
        });
        
        
        List<Pair> list = new ArrayList<>();
        Pair pair = new Pair(intervals[0][0], intervals[0][1]);
        
        for(int i = 1; i  < intervals.length; i++) {
            int array[] = intervals[i];
            
            // combine
            if(pair.second >= array[0]) {
                pair.second = Math.max(pair.second, array[1]);
                if(i == intervals.length-1) {
                    list.add(pair);
                }
            } else {
                list.add(pair);
                pair = new Pair(array[0], array[1]);
                if(i == intervals.length-1) {
                    list.add(pair);
                }
            }
        }
      
        int[][] sol = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++) {
            sol[i][0] = list.get(i).first;
            sol[i][1] = list.get(i).second;
        }
        
        // iterate and merge 
        return sol;
    }
     
    
    class Pair
    {
        int first;
        int second;
        public Pair(int first, int second)
        {
            this.first = first;
            this.second =second;
        }

    }
}
