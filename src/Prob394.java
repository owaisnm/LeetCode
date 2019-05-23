
public class Prob394 {
	public String decodeString(String s) {
        StringBuilder sb = new StringBuilder(s);
        decode(sb, -1); 
        return sb.toString();
    }
    
    private void decode(StringBuilder sb, int open) {
        int nextOpen = sb.indexOf("[", open+1);
        int nextClose = sb.indexOf("]", open+1);
        
        if(nextOpen != -1 && nextOpen < nextClose) {
            decode(sb, nextOpen);
        } 
        
        nextClose = sb.indexOf("]", open+1);
        if (nextClose != -1) {
            int j = open-1;
            while(j >= 0 && Character.isDigit(sb.charAt(j))) {
                j--;
            }
            j++;
            int multiple = Integer.parseInt(sb.substring(j, open));
            String stringToBeRepeated = sb.substring(open+1, nextClose);
            String multipliedString = getRepeatedString(stringToBeRepeated, multiple);
            sb.delete(j, nextClose+1);
            sb.insert(j, multipliedString);
            
            nextOpen = sb.indexOf("[", open+1);
            if(nextOpen != -1) {
                decode(sb, nextOpen);
            }
        }
    }
    
    String getRepeatedString(String string, int multiple) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < multiple; i++) {
            sb.append(string);
        }
        return sb.toString();
    }
}
