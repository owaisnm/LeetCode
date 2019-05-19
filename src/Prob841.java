import java.util.LinkedList;
import java.util.List;

public class Prob841 {
	 public boolean canVisitAllRooms(List<List<Integer>> rooms) {
	        boolean visited[] = new boolean[rooms.size()];        
	        LinkedList<Integer> queue = new LinkedList<>();
	        queue.add(0);
	        
	        while(!queue.isEmpty()) {
	            int num = queue.poll();
	            visited[num] = true;
	            for(int i = 0; i < rooms.get(num).size(); i++) {
	                if(!visited[rooms.get(num).get(i)]) {
	                    queue.add(rooms.get(num).get(i));
	                }
	            }
	        }
	        
	        for(int i = 0; i < visited.length; i++) {
	            if(!visited[i]) {
	                return false;
	            }
	        }
	        return true;
	    }
}
