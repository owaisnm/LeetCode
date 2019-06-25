
public class Prob96 {
public int numTrees(int n) {
        
        // using Catalan numbers sequence: 
        // G(n) = summation from i = 1 to i = n of G(n-i)*G(i-1)
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                dp[i] += dp[i-j] * dp[j-1]; 
            }
        }
        return dp[n];
    }
}
