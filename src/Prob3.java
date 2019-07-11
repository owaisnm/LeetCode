import java.util.HashMap;

public class Prob3 {
	public int lengthOfLongestSubstring(String s) {
	        HashMap<Character, Integer> map = new HashMap<>();
	        int maxLength = 0;
	        int length = 0;
	        int start = 0;
	        for(int i = 0; i < s.length(); i++) {
	            Integer index = map.get(s.charAt(i));
	            map.put(s.charAt(i),i);
	            if(index != null) {
	                if(index.intValue() >= start) {
	                    start = index.intValue();                    
	                }
	                length = i - start;
	            } else {
	                length++;
	            }
	            maxLength = Math.max(maxLength, length);
	        }
	        return maxLength;
}
