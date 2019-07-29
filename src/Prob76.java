import java.util.HashMap;

public class Prob76 {
	    
public String minWindow(String s, String t) {
        
        HashMap<Character, Integer> map = new HashMap<>();
        
        for(char c : s.toCharArray()) {
            map.put(c, 0);
        }
        for(char c: t.toCharArray()) {
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                return "";
            }
        }
        
        int start, end, minStart, minEnd;
        start = end = minStart = minEnd = 0;
        int minLength = Integer.MAX_VALUE;
        int counter = t.length();
        char c;
        while(end < s.length()) {
            c = s.charAt(end);
            if(map.get(c) > 0) {
                counter--;
            }
            map.put(c, map.get(c) - 1);
            end++;
            
            // while start and end are a valid window 
            while(counter == 0) {

                if(end - start < minLength) {
                    minStart = start;
                    minEnd = end;
                    minLength = end - start;
                }
                
                c = s.charAt(start);
                map.put(c, map.get(c) + 1);
                if(map.get(c) > 0) {
                    counter++;
                }
                start++;
            }
        }
        
        if(minLength == Integer.MAX_VALUE) {
            return "";
        }
        return s.substring(minStart, minEnd);
    }
}
