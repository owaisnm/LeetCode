
public class Prob461 {
	public int hammingDistance(int x, int y) {
        String bin1 = new StringBuilder(Integer.toBinaryString(x)).reverse().toString();
        String bin2 = new StringBuilder(Integer.toBinaryString(y)).reverse().toString();
        int length = Math.max(bin1.length(), bin2.length());
        int diffCount = 0;

        for(int i = 0; i < length; i++) {
            if(i >= bin1.length() ) {
                if(bin2.charAt(i) == '1') {
                    diffCount++;                    
                }
            } else if(i >= bin2.length()) {
                if(bin1.charAt(i) == '1') {
                    diffCount++;
                }
            } else if(bin1.charAt(i) != bin2.charAt(i)) {
                diffCount++;
            }
        }
        return diffCount;
    }
}
