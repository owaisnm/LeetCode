import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Prob819 {
	public String mostCommonWord(String paragraph, String[] banned) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        for(String s: banned) map.put(s.toLowerCase(), -1);
        StringBuilder sb = new StringBuilder(paragraph.toLowerCase());
        for(int i = 0; i < sb.length(); i++) {
            if(sb.charAt(i) < 'a' || sb.charAt(i) > 'z')
                sb.setCharAt(i, ' ');
        }
        String[] pWords = sb.toString().split("\\s+");
        int count;
        for(String s: pWords) {
            count = map.get(s) == null ? 0 : map.get(s).intValue();
            if(count == 0) map.put(s, 1);
            else if(count != -1) map.put(s, count +  1);
        }
        
        Iterator it = map.entrySet().iterator();
        Map.Entry<String, Integer> entry;
        int max = Integer.MIN_VALUE;
        String most = null;
        while(it.hasNext()) {
            entry = (Map.Entry<String, Integer>) it.next();
            count = entry.getValue().intValue();
            if(count > max) {
                max = count;
                most = entry.getKey();
            }
        }
        return most;
    }
}
