
public class Prob351 {
	int total = 0;
    public int numberOfPatterns(int m, int n) {
        // create 3x3 board
        // begin recursion algo from any square
        // base case:   if beyond board bounds or > n, return
        //              else if >= m && <= n record step
        
        boolean[] visited = new boolean[10];
        int[][] skip = new int[10][10];
        skip[1][3] = skip[3][1] = 2;
        skip[1][7] = skip[7][1] = 4;
        skip[3][9] = skip[9][3] = 6;
        skip[7][9] = skip[9][7] = 8;
        skip[1][9] = skip[2][8] = skip[3][7] = skip[6][4] = skip[9][1] = skip[8][2] = skip[7][3] = skip[4][6] = 5;
        for(int i = 1; i < 10; i++) {
            numberOfPatterns(visited, skip, m, n, i, 1); 
        }
        return total;
    }
    
    void numberOfPatterns(boolean[] visited, int[][] skip, int m, int n, int current, int count) {
        if(visited[current] || count > n) {
            return;
        }
        visited[current] = true;
        if(count >= m) {
            total++;
        }
        for(int i = 1; i < 10; i++) {
            if(i == current || (skip[current][i] != 0 && !visited[skip[current][i]])) {     
                continue;
            } 
            numberOfPatterns(visited, skip, m, n, i, count + 1);
        }
        visited[current] = false;
    }
    
}
