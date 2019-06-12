
public class Prob67 {
	  public String addBinary(String a, String b) {
	        boolean carry = false;
	        StringBuilder sb = new StringBuilder();
	        a = new StringBuilder(a).reverse().toString();
	        b = new StringBuilder(b).reverse().toString();
	        int length = Math.max(a.length(), b.length());
	        int aInt, bInt;
	        for(int i = 0; i < length; i++) {
	            aInt = Character.getNumericValue(i < a.length() ? a.charAt(i) : '0');
	            bInt = Character.getNumericValue(i < b.length() ? b.charAt(i) : '0');
	            
	            if(aInt + bInt == 2) {
	                if(carry) {
	                    sb.append("1");
	                } else {
	                    sb.append( "0");
	                    carry = true;
	                }
	            } else if(aInt + bInt == 1) {
	                if(carry) {
	                    sb.append("0");
	                } else {
	                    sb.append("1");
	                }
	            }  else if(aInt + bInt == 0) {
	                  if(carry) {
	                    sb.append("1");
	                    carry = false;
	                } else {
	                    sb.append("0");
	                }
	            }
	        }
	        if(carry) {
	            sb.append("1");
	        }
	        return sb.reverse().toString();
	    }
}
