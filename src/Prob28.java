
public class Prob28 {
	public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }
        int i = 0;
        int j, count;
        while(i < haystack.length() - needle.length() + 1) {
            if(haystack.charAt(i) == needle.charAt(0)) {
                j = i;
                count = 0;
                while(count < needle.length()) {
                    if(haystack.charAt(j) != needle.charAt(count)) {
                        break;
                    }
                    count++;
                    j++;
                }
                if(count == needle.length()) {
                    return i;
                }
            }
            i++;
        }
        return -1;
    }
}
