
public class Prob62 {
    
    public int uniquePaths(int m, int n) {
        return uniquePathsRecursiveDP(new int[m][n], m, n, 0, 0, 0);
    }
    
    // causes TLE error
    public int uniquePathsRecursive(int m, int n, int x, int y, int count) {
        if(x >= m || y >= n) {
            return count;
        }
        if(x == m-1 && y == n-1) {
            count++;
            return count;
        }
        return uniquePathsRecursive(m, n, x + 1, y, count) + uniquePathsRecursive(m, n, x, y + 1, count);
    }
    
    // T: O(m*n), S: O(m*n)    
     public int uniquePathsRecursiveDP(int[][] dp, int m, int n, int x, int y, int count) {
        if(x >= m || y >= n) {
            return count;
        }
        if(x == m-1 && y == n-1) {
            count++;
            return count;
        }
         
         int down, right;
         down = right = 0;
         if(x + 1 < m) {
            if(dp[x+1][y] == 0) {
                dp[x+1][y] = uniquePathsRecursiveDP(dp, m, n, x + 1, y, count);
            } 
            right =  dp[x+1][y];
         }
         if(y + 1 < n) {
            if(dp[x][y+1] == 0) {
                dp[x][y+1] = uniquePathsRecursiveDP(dp, m, n, x, y + 1, count);   
            }
            down = dp[x][y+1];
         }
         return down + right;
    }
}
