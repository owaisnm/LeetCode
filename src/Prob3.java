import java.util.HashSet;
import java.util.Set;

public class Prob3 {
	public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        char curr;
        int length;
        int lengthOfLongestSubstring = 0;
        int i = 0;
        while(i < s.length()) {
            length = 0;
            while(i < s.length() && !set.contains(s.charAt(i))) {
                set.add(s.charAt(i));
                length++;
                i++;
            }
            
            if(i < s.length()) {
                curr = s.charAt(i);
                set.clear();
                i--;

                while(i > 0 && s.charAt(i) != curr) i--;   
                i++;
            }
            if(length > lengthOfLongestSubstring) lengthOfLongestSubstring = length;
            set.clear();
        }
        return lengthOfLongestSubstring;
    }
}
