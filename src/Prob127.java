import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Prob127 {
	 public int ladderLength(String beginWord, String endWord, List<String> wordList) {

	        int wordLength = beginWord.length();
	        List<String> startingWords = new ArrayList<>();
	        int diffCount;
	        Map<String, List<String>> map = new HashMap<String, List<String>>();
	        
	        // create adjacency list
	        for(int i = 0; i < wordList.size(); i++) {
	            for(int j = 0; j < wordList.size(); j++) {
	                if(i==j) {
	                    continue;
	                }
	                diffCount = 0;
	                for(int k = 0; k < wordLength; k++) {
	                    if(wordList.get(i).charAt(k) != wordList.get(j).charAt(k)) {
	                        diffCount++;
	                    }
	                }   
	                if(diffCount == 1) {
	                    List<String> list = map.get(wordList.get(i));
	                    if(list == null) {
	                        list = new ArrayList<String>();
	                    }
	                    list.add(wordList.get(j));
	                    map.put(wordList.get(i), list);
	                }
	                diffCount = 0;
	            }
	        }
	        
	        // print adjacency list
	        // Iterator iterator = map.entrySet().iterator();
	        // while(iterator.hasNext()) {
	        //     Map.Entry<String, List<String>> entry = (Map.Entry<String, List<String>>) iterator.next();
	        //     System.out.print(entry.getKey() +": ");
	        //     for(String word : entry.getValue()) {
	        //         System.out.print(word + ",");
	        //     }
	        //     System.out.println();
	        // }
	    
	        // identify words 1 char diff from beginning word,
	        
	        int beginDiffCount;
	                System.out.println(beginWord+", ");
	        for(int i = 0; i < wordList.size(); i++) {
	            beginDiffCount = 0;
	            for(int k = 0; k < wordLength; k++) {
	                if(beginWord.charAt(k) != wordList.get(i).charAt(k)) {
	                    beginDiffCount++;
	                }
	            }
	            if(beginDiffCount == 1) {
	                startingWords.add(wordList.get(i));
	            } 
	            beginDiffCount = 1;
	        }
	        if(startingWords.size() == 0) {
	            return 0;
	        }
	        
	        List<String> result = map.get(beginWord);
	        if(result == null) {
	            map.put(beginWord, startingWords);
	        }
	        
	        Queue<String> queue = new LinkedList<>();
	        Set<String> discovered = new HashSet<>();
	        queue.add(beginWord);
	        discovered.add(beginWord);
	        int shortest = 2;    
	        
	        // use BFS to iterate using a queue
	        while(!queue.isEmpty()) {
	            int n = queue.size();
	            for(int i = 0; i < n; i++) {
	                String word = queue.poll();
	                startingWords = map.get(word);
	                if(startingWords != null && startingWords.size() > 0) {
	                    for(String sWord: startingWords) {
	                        if(!discovered.contains(sWord)) {
	                            discovered.add(sWord);
	                            queue.add(sWord);
	                        }
	                        if(sWord.equals(endWord)) {
	                            return shortest;
	                        }
	                    }     
	                }
	            }
	            shortest++;
	        }
	        return 0;
	    }
}
