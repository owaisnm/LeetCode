
public class Prob79 {
	boolean found;
    public boolean exist(char[][] board, String word) {
        int index = 0;
        boolean visited[][] = new boolean[board.length][board[index].length];
        for(int i = 0; i < board.length; i++) { 
            for(int j = 0; j < board[i].length; j++) {
                    exist(board,visited,  word, i, j, index);
            }
        }
        return found;
    }
    
    void exist(char[][] board, boolean[][] visited, String word, int x, int y, int index) {

        if(found || x < 0 || y < 0 || x > board.length-1 || y > board[x].length-1) {
            return;
        } else if(visited[x][y] || board[x][y] != word.charAt(index)) {
            return;
        } 
        
        index++;
        if(index == word.length()) {
            found = true;
            return;
        }
        
        visited[x][y] = true;
        exist(board, visited, word, x-1, y, index);
        exist(board, visited, word, x, y-1, index);
        exist(board, visited, word, x+1, y, index);
        exist(board, visited, word, x, y+1, index);
        visited[x][y] = false;
    }
}
