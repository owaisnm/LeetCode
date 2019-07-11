
public class Prob246 {
	public boolean isStrobogrammatic(String num) {
        StringBuilder reverse = new StringBuilder(num).reverse();
        for(int j = 0; j < reverse.length(); j++) {
            if(reverse.charAt(j) == '2' || reverse.charAt(j) == '3' || reverse.charAt(j) == '4' || reverse.charAt(j) == '5' || reverse.charAt(j) == '7') {
                return false;
            }
            if(reverse.charAt(j) == '6') {
                reverse.setCharAt(j, '9');
            } else if(reverse.charAt(j) == '9') {
                reverse.setCharAt(j, '6');
            }
        }

        if(num.equals(reverse.toString())) {
            return true;
        }
        return false;
    }
}
