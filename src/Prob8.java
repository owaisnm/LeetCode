
public class Prob8 {
	public int myAtoi(String str) {    
        long integer = 0; 
        long multiple = 10;
        boolean numberSeen = false;
        boolean negative = false;
        boolean signSeen = false;
        char c = Character.MIN_VALUE;
        
        for(int i = 0; i < str.length(); i++) {
            c = str.charAt(i);
            
            if(c < '0' || c > '9') {
                if(numberSeen) {
                    break;
                } else if(signSeen && (c < '0' || c > '9')) {
                    return 0;
                } else if(c == '-') {
                    signSeen = true;
                    negative = true;
                } else if(c == '+') {
                    signSeen = true;
                } else if(c != ' ') {
                    return 0;
                }
            } else {
                numberSeen = true;
                integer = integer * multiple + (c - '0');
            }
            
            if(integer > Integer.MAX_VALUE) {
                break;
            }
        }
        if(negative) {
            integer *= -1;
        }
        if(integer < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if(integer > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        }
        return (int) integer;
    }
}
