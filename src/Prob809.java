import java.util.HashSet;
import java.util.Set;

public class Prob809 {
	public int expressiveWords(String S, String[] words) {
        StringBuilder thisWord;
        int sol = 0;
        int i, j, k;
        int baseK, baseJ, baseCount;
        i = 0;
        baseJ = j = 0;
        baseK = k = 0;
        int count = 0;
        
        for(i = 0; i < words.length; i++) {
            thisWord = new StringBuilder(words[i]);
            j = 0;
            baseJ = 0;
            while(j < thisWord.length()) {
                count = 0;
                baseCount = 0;
                char thisChar = thisWord.charAt(j);
                if(S.charAt(baseJ) != thisWord.charAt(j)) {
                    break;
                }

                k = j;
                baseK = baseJ;
                while(baseK < S.length() && S.charAt(baseK) == thisChar) {
                    baseK++;
                }
                while(k < thisWord.length() && thisWord.charAt(k) == thisChar) {
                    k++;
                }
                count = k - j;
                baseCount = baseK - baseJ;
                j = k;
                baseJ = baseK;
                if(count != baseCount && (baseCount < 3 || count >= baseCount)) {
                    break;
                }
                
                if(baseJ == S.length() && j == thisWord.length()) {
                    sol++;
                } 
            }
        }
        return sol;
    }
}
