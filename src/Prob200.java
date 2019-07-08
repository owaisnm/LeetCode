
public class Prob200 {
	int count = 0;
    public int numIslands(char[][] grid) {
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(numIslands(i, j, grid)) {
                    count++;
                }
            }
        }
        return count;
    }
    
    public boolean numIslands(int i, int j, char grid[][]) {
        if(i == grid.length || j == grid[0].length || i < 0 || j < 0 || grid[i][j] == '0') {
            return false;
        }
        if(grid[i][j] == '1') {
            grid[i][j] = '0';
            numIslands(i-1, j, grid);
            numIslands(i+1, j, grid);
            numIslands(i, j-1, grid);
            numIslands(i, j+1, grid);
            return true;
        } 
        return false;
    }
}
