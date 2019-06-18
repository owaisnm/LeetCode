
public class Prob256 {
	 public int minCost(int[][] costs) {
	        
	        if(costs.length == 0) {
	            return 0;
	        }
	        
	        int prevRed, prevBlue, prevGreen;
	        prevRed = costs[0][0];
	        prevBlue = costs[0][1];
	        prevGreen = costs[0][2];
	        int minRed = prevRed;
	        int minBlue = prevBlue;
	        int minGreen = prevGreen;
	        for(int i = 1; i < costs.length; i++) {
	            minRed = costs[i][0] + Math.min(prevBlue, prevGreen);
	            minBlue = costs[i][1] + Math.min(prevRed, prevGreen);
	            minGreen = costs[i][2] + Math.min(prevRed, prevBlue);
	            
	            prevRed = minRed;
	            prevBlue = minBlue;
	            prevGreen = minGreen;
	            
	        }
	        return Math.min(Math.min(minRed, minBlue), minGreen);
	    }
}
