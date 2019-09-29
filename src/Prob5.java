
public class Prob5 {
	 public String longestPalindrome(String s) {
	        if(s.length() < 2) {
	            return s;
	        }
	        
	        int max = 1;
	        int start = 0;
	        boolean[][] dp = new boolean[s.length()][s.length()];
	        
	        for(int i = 0; i < s.length(); i++) {
	            for(int j = 0; j < i; j++) {
	                if(j == i) {
	                    dp[j][i] = true;
	                }
	                else if(i - j < 3) {
	                    dp[j][i] = s.charAt(j) == s.charAt(i);
	                    if(dp[j][i] && max < i+1-j) {
	                        max = i+1-j;
	                        start = j;
	                    }
	                } else {
	                    if(dp[j+1][i-1] && s.charAt(j) == s.charAt(i)) {
	                        dp[j][i] = true;
	                        if(max < i+1-j) {
	                            max = i+1-j;
	                            start = j;
	                        }
	                    } else {
	                        dp[j][i] = false;
	                    }
	                }
	            }
	        }
	        return s.substring(start, start + max);
	    }
}
