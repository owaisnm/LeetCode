
public class Prob326 {
	public boolean isPowerOfThree(int n) {
        double tol = 0.0000000001;
        double x = Math.log(n) / Math.log(3);
        return Math.abs(x - Math.round(x)) < tol;
    }
}
