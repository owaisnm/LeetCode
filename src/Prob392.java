
public class Prob392 {
	public boolean isSubsequence(String s, String t) {
        if(t.length() == 0) {
            return s.length() == 0;
        }
        
        int ti = 0;
        int si = 0;
        while(si < s.length() && ti < t.length()) {
            if(t.charAt(ti) == s.charAt(si)) {
                si++;
            }
            ti++;
        }
        return si == s.length();
    }
}
