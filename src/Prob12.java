
public class Prob12 {
	public String intToRoman(int num) {
        int[] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] romans = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        
        int i = 0;
        int mod, div;
        StringBuilder sb = new StringBuilder();
        while(num > 0) {
            div = num / nums[i];
            mod = num % nums[i];
            if(div > 0) {
                sb.append(romans[i]);
                System.out.println(nums[i]);
                num -= nums[i];
                while(num > 0 && num < 4) {
                    sb.append(romans[romans.length - 1]);
                    num -= nums[nums.length - 1];
                    System.out.println(num);
                }
            } else {
                i++;
            }
        }
        return sb.toString();
    }
}
