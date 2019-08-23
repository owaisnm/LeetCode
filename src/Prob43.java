
public class Prob43 {
    public String multiply(String num1, String num2) {
        
        int n1, n2, carry, tmp, index, prevIndex;
        index = prevIndex = carry = 0;
        
        int[] product = new int[num1.length() + num2.length()];
        
        for(int i = num2.length()-1; i > -1; i--) {
            n2 = (int) num2.charAt(i) - 48;
            index = prevIndex;
            carry = 0;
            for(int j = num1.length()-1; j > -1; j--) {
                n1 = (int) num1.charAt(j) - 48;
                tmp = n1*n2 + carry + product[index];
                if(tmp > 9) {
                    product[index] = tmp%10;
                    carry = tmp/10;
                } else {
                    product[index] = tmp;
                    carry = 0;
                }                
                index++;
                if(j == 0 && carry > 0) {
                    product[index] = carry;
                }
            }
            prevIndex++;
        }
       
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while(i < product.length) {
            sb.append(product[i]);
            i++;
        }
        i = sb.length() - 1;
        while(i > -1 && sb.charAt(i) == '0') {
            sb.deleteCharAt(i);
            i--;
        }
        if(sb.length() == 0) {
            return "0";
        }
        return sb.reverse().toString();
    }
}
