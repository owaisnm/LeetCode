
public class Prob64 {
public int minPathSum(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int minSums[][] = new int[m][n];
        
        // iterative
        // T: O(n*m), S: O(n*m)
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(i - 1 > -1 && j - 1 > -1) {
                    minSums[i][j] = grid[i][j] + Math.min(minSums[i-1][j], minSums[i][j-1]);
                } else if(i - 1 > -1) {
                    minSums[i][j] = grid[i][j] + minSums[i-1][j];
                } else if(j - 1 > -1) {
                    minSums[i][j] = grid[i][j] + minSums[i][j-1];
                } else {
                    minSums[i][j] = grid[i][j];
                }
            }
        }
        return minSums[m-1][n-1];
    }
    
    // recursive + memoization using bottom-up strategy
    // T: O(m*n), S:O(m*n) + O(m+n) stack space for recursion
    public void minPathSumRecursive(int[][] grid, int[][] minSums, int sum, int m, int n, int i, int j) {
        
        if(i == m || j == n) {
            return;
        }
        
        sum += grid[i][j];
        
        if(minSums[i][j] == -1 || sum < minSums[i][j]) {
            minSums[i][j] = sum;
            minPathSumRecursive(grid, minSums, sum, m, n, i + 1, j);
            minPathSumRecursive(grid, minSums, sum, m, n, i, j + 1);
        }
    }
}
