import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

public class Prob743 {
	  
    public int networkDelayTime(int[][] times, int N, int K) {
        boolean[][] adjacencyMatrix = new boolean[N+1][N+1];
        Map<String, Integer> edgeMap = new HashMap<>();
        Map<Integer, Integer> timeMap = new HashMap<>();
        boolean[] visited = new boolean[N+1];
        for(int[] time : times) {
            adjacencyMatrix[time[0]][time[1]] = true;
            edgeMap.put(time[0]+"-"+time[1], time[2]);
        }
        
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> (a[0]-b[0]));
        pq.add(new int[]{0, K});
        visited[K] =true;
        timeMap.put(K, 0);
        int[] next;
        while(!pq.isEmpty()) {
            next = pq.remove();
            visited[next[1]] = true;
            for(int i = 1; i < N+1; i++) {
                if(adjacencyMatrix[next[1]][i]) {
                    int distance = next[0]+edgeMap.get(next[1]+"-"+i);
                    if(!timeMap.containsKey(i)) {
                        timeMap.put(i, distance);
                    } else {
                        timeMap.put(i, Math.min(timeMap.get(i), distance));
                    }
                
                    if(!visited[i]) {
                        pq.add(new int[] {distance,i});
                    }
                }
            }
        }
        
        for(int i = 1; i < N+1; i++) {
            if(!timeMap.containsKey(i)) {
                return -1;
            }
        }
        
        int maxTime = 0;
        Iterator i = timeMap.entrySet().iterator();
        while(i.hasNext()) {
            maxTime = Math.max(maxTime, ((Map.Entry<Integer, Integer>)i.next()).getValue());
        }
        return maxTime;
    }

}
