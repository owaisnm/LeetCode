
public class Prob714 {
	  public int maxProfit(int[] prices, int fee) {
	        int cash = 0;
	        int hold = -prices[0];
	        for(int i = 1; i < prices.length; i++) {
	            cash = Math.max(hold + prices[i] - fee, cash);
	            hold = Math.max(cash - prices[i], hold);
	        }
	        return cash;
	    }
}
