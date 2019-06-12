
public class Prob121 {
	 public int maxProfit(int[] prices) {
	        if(prices.length < 2) {
	            return 0;
	        }
	        int maxProfit = 0;
	        int minPrice = prices[0];
	        
	        for(int i = 1; i < prices.length; i++) {
	            minPrice = Math.min(minPrice, prices[i]);
	            maxProfit = Math.max(maxProfit, prices[i] - minPrice);
	        }
	        return maxProfit;
	    }
}
