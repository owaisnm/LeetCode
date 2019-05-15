
public class Prob345 {
	public String reverseVowels(String s) {
        StringBuilder sb = new StringBuilder(s);
        int l, r;
        char tmp;
        l = 0;
        r = sb.length() - 1;
        while(l < r) {
            if(!isVowel(sb.charAt(l))) {
                l++;
            } 
            if(!isVowel(sb.charAt(r))) {
                r--;
            }
            if(isVowel(sb.charAt(l)) && isVowel(sb.charAt(r))) {
                tmp = sb.charAt(l);
                sb.setCharAt(l, sb.charAt(r));
                sb.setCharAt(r, tmp);
                l++;
                r--;
            }
        }
        return sb.toString();
    }
    
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u'
        || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
