
public class Prob415 {
	public String addStrings(String num1, String num2) {
        int i1 = num1.length() - 1;
        int i2 = num2.length() - 1;
        int c1, c2, c;
        boolean carry = false;
        
        StringBuilder sb = new StringBuilder();
        while(i1 > -1 || i2 > -1) {
            c1 = i1 > -1 ? (num1.charAt(i1) - 48) : 0;
            c2 = i2 > -1 ? (num2.charAt(i2) - 48) : 0;
            c = c1 + c2 + (carry ? 1 : 0);
            carry = c > 9;
            sb.append((char)c%10);
            i1--;
            i2--;
        }
        if(carry) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }
}
