
public class Prob647 {
    int count = 0;
    
    public int countSubstrings(String s) {
    
        // extending palindrome
        for(int i = 0; i < s.length(); i++) {
            countSubstrings(s, i, i);
            countSubstrings(s, i, i + 1);
        }
        return count;
    }
    
    public void countSubstrings(String s, int left, int right) {    
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
    }

}
