import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prob139 {
	 public boolean wordBreak(String s, List<String> wordDict) {
	        Queue<Integer> queue = new LinkedList<Integer>();
	        StringBuilder sb = new StringBuilder(s);
	        String word;
	        int j;
	        int visited[] = new int[s.length()];
	        
	        // initial pass to enqueue indices into the queue
	        for(int i = 0; i < wordDict.size(); i++) {
	            word = wordDict.get(i);
	            if(word.length() <= sb.length() && sb.charAt(0) == word.charAt(0) && sb.substring(0, word.length()).equals(word)) {
	                queue.add(word.length());
	            }
	        }
	        
	        while(!queue.isEmpty()) {
	            j = queue.poll();
	            if(j == sb.length()) {
	                return true;
	            }
	            for(int i = 0; j < sb.length() && i < wordDict.size(); i++) {
	                word = wordDict.get(i);
	                if(visited[j] == 0 && (j+word.length() <= sb.length()) && sb.charAt(j) == word.charAt(0) && sb.substring(j, j + word.length()).equals(word)) {
	                    queue.add(j + word.length());
	                }
	            }
	            visited[j] = 1;
	        }
	        return false;
	    }
}
