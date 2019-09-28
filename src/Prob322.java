import java.util.HashMap;
import java.util.Map;

public class Prob322 {
	public int coinChange(int[] coins, int amount) {
        return coinChange(new HashMap<Integer, Integer>(), coins, amount, 0);
    }
    
    public int coinChange(Map<Integer, Integer> dp, int[] coins, int amount, int coinCount) {
        if(amount < 0) 
            return -1;
        if(amount == 0) 
            return 0;
        if(dp.containsKey(amount))
            return dp.get(amount);
        
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < coins.length; i++) {
            int count = coinChange(dp, coins, amount - coins[i], coinCount + 1);
            if(count >= 0 && count < min) {
                min = Math.min(count, min) + 1;
            }
        }
        
        dp.put(amount, min < Integer.MAX_VALUE ? min  : -1);
        return dp.get(amount); 
    }
}
