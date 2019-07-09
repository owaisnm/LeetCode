
public class Prob482 {
	public String licenseKeyFormatting(String S, int K) {
        int count;
        StringBuilder sb = new StringBuilder(S.toUpperCase());
        for(int i = sb.length()-1; i > -1;) {
            count = 0;
            while(i > -1 && count < K) {
                if(sb.charAt(i) == '-') {
                    sb.deleteCharAt(i);
                } else {
                    count++;
                }
                i--;
            }
            if(i > -1 && sb.charAt(i+1) != '-') {
                sb.insert(i+1, '-');
            }
        }
        
        if(sb.length() > 0 && sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}
