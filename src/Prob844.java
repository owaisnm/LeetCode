
public class Prob844 {
	 public boolean backspaceCompare(String S, String T) {
	        // compare string using 2 points from right to left
	        // skip all chars occuring after # as we can be sure to ignore them
	        
	        int i1, i2;
	        i1 = S.length()-1;
	        i2 = T.length()-1;
	        int count1, count2;
	        count1 = count2 = 0;
	        
	        while(i1 > -1 && i2 > -1) {
	            while(i1 > -1 && (S.charAt(i1) == '#' || count1 > 0)) {
	                if(S.charAt(i1) == '#') {
	                    count1++;
	                } else {
	                    count1--;
	                }
	                i1--;
	            }
	            count1 = 0;
	            while(i2 > -1 && (T.charAt(i2) == '#' || count2 > 0)) {
	                if(T.charAt(i2)== '#') {
	                    count2++;   
	                } else {
	                    count2--;
	                }
	                i2--;
	            }
	            count2 = 0;
	        
	            if(i1 > -1 && i2 > -1) {
	                if(S.charAt(i1) != T.charAt(i2)) {
	                    return false;
	                }
	                i1--;
	                i2--;
	            }
	        }
	        
	       while(i1 > -1 && (S.charAt(i1) == '#' || count1 > 0)) {
	            if(S.charAt(i1) == '#') {
	                count1++;
	            } else {
	                count1--;
	            }
	            i1--;
	        }
	        while(i2 > -1 && (T.charAt(i2) == '#' || count2 > 0)) {
	            if(T.charAt(i2) == '#') {
	                count2++;
	            } else {
	                count2--;
	            }
	            i2--;
	        }

	        if(i1 > -1 || i2 > -1) {
	                    return false;
	                }
	        return true;
	    }
}
