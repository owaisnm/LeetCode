import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Prob253 {
	 public int minMeetingRooms(int[][] intervals) {
        if(intervals.length == 0) {
            return 0;
        }
        
        Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
                int val = o1[0] - o2[0];
                if(val == 0) {
                    return o1[1] - o2[1];
                }
                return val;
			}
        });
        
        int i = 0;
        List<Integer> roomsNeededList = new ArrayList<>();
        
        while(i < intervals.length) {
            for(int j = intervals[i][0]; j < intervals[i][1]; j++) {
                if(roomsNeededList.size() <= j) {
                    for(int x = roomsNeededList.size()-1; x < j; x++) {
                        roomsNeededList.add(0);
                    }
                }
                roomsNeededList.set(j,roomsNeededList.get(j) + 1);
            }
            i++;
    }
        
        int max = 0;
        for (i = 0; i < roomsNeededList.size(); i++) {
            if(roomsNeededList.get(i) > max) {
                max = roomsNeededList.get(i);
            }
        }
        return max;
    }
}
