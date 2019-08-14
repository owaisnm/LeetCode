
public class Prob329 {
	public int longestIncreasingPath(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return 0;
        }
        
        int n = matrix.length;
        int m = matrix[0].length;
        int localMax = 0;
        int[][] cache = new int[n][m];
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(cache[i][j] == 0) {
                    localMax = Math.max(localMax, backtrack(matrix, cache, i, j, n, m));
                }
            }
        }
        return localMax;
    }
        
    int backtrack(int[][] matrix, int cache[][], int x, int y, int n, int m) {
        int localMax = 1;
        if(y-1 > -1 && matrix[x][y-1] > matrix[x][y]) {
            if(cache[x][y-1] > 0) {
                localMax = Math.max(localMax, 1 + cache[x][y-1]);
            } else {
                localMax = Math.max(localMax, 1 + backtrack(matrix, cache, x, y-1, n, m));
            }
        }
        
        if(y+1 < m && matrix[x][y+1] > matrix[x][y]) {
            if(cache[x][y+1] > 0) {
                localMax = Math.max(localMax, 1 + cache[x][y+1]);
            } else {
                localMax = Math.max(localMax,1 + backtrack(matrix, cache, x, y+1,n, m));
            }
        }
        
        if(x-1 > -1 && matrix[x-1][y] > matrix[x][y]) {
            if(cache[x-1][y] > 0) {
                localMax = Math.max(localMax, 1 + cache[x-1][y]);
            } else {
                localMax = Math.max(localMax,1 + backtrack(matrix, cache, x-1, y, n, m));
            }
        }

        if(x+1 < n && matrix[x+1][y] > matrix[x][y]) {
            if(cache[x+1][y] > 0) {
                localMax = Math.max(localMax, 1 + cache[x+1][y]);
            } else {
                localMax = Math.max(localMax,1 + backtrack(matrix, cache, x+1, y, n, m ));
            }
        }
        cache[x][y] = localMax;
        return localMax;
    }
}
