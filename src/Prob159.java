
public class Prob159 {
	public int lengthOfLongestSubstringTwoDistinct(String s) {
        if(s.length() == 0) {
            return 0;
        } else if(s.length() == 1) {
            return 1;
        } else if(s.length() == 2) {
            return 2;
        }
        
        int i1, i2;
        i1 = 0;
        i2 = 1;
        char char1 = s.charAt(i1);
        char char2 = s.charAt(i2);
        char thisChar, beforeChar;
        int maxLength = 2;
        int length = 2;
        
        for(int i = 2; i < s.length(); i++) {
            thisChar = s.charAt(i);
            beforeChar = s.charAt(i-1);
            if(char1 == char2 && char1 == thisChar)  {
                length++;
            } else if(char1 == char2 && char1 != thisChar) {
                char2 = thisChar;
                i2 = i;
                length++;
            } else {
                if(thisChar == char1) {
                    if(beforeChar == char2) {
                        i1 = i;
                    }
                    length++;
                } else if(thisChar == char2) {
                    if(beforeChar == char1) {
                        i2 = i;
                    }
                    length++;
                } else {
                    if(beforeChar == char1) {
                        length = i - i1 + 1;
                        char2 = thisChar;
                        i2 = i;
                    } else {
                        length = i - i2 + 1;
                        char1 = thisChar;
                        i1 = i;
                    }
                }
            }
            if(length > maxLength) {
                maxLength = length;
            }
        }
        return maxLength;
    }
}
