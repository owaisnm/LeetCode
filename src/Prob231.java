
public class Prob231 {
	 public boolean isPowerOfTwo(int n) {
	        
	        double tol = 0.0000000001;
	        double d = Math.log(n) / Math.log(2);
	        return Math.abs(d - Math.round(d)) < tol;
	    }
}
