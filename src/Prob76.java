import java.util.HashMap;
import java.util.HashSet;

public class Prob76 {
	    
public String minWindow(String s, String t) {
        
        HashSet<Character> set = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();
        int start, end, counter, windowStart, windowEnd;
        char c1, c2;
        start = end = counter = 0;
        windowStart = windowEnd = -1;
        
        for(char c : t.toCharArray()) {
            set.add(c);
            map.put(c, map.getOrDefault(c, 0) + 1);
            counter++;
        }
        while(end < s.length()) {
            c1 = s.charAt(end);
            if(set.contains(c1)) {
                if(map.get(c1) > 0) counter--;
                map.put(c1, map.get(c1) - 1);
            }
            end++;
            while(start < end && counter == 0) {
                c2 = s.charAt(start);
                if(windowStart == -1 || end - start < windowEnd - windowStart) {
                    windowStart = start;
                    windowEnd = end;
                }
                if(set.contains(c2)) {
                    map.put(c2, map.get(c2) + 1);
                    if(map.get(c2) > 0) counter++;
                }
                start++;
            }
        }
        return windowStart == -1 ? "" : s.substring(windowStart, windowEnd);
    }
}
