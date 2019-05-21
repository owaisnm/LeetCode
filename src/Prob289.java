
public class Prob289 {
	 public void gameOfLife(int[][] board) {
	        int l = board.length;
	        int w = board[0].length;
	        int liveNeighbors;
	        int ref[][] = new int[l][w];
	        
	        for(int i = 0; i < l; i++) {
	            for(int j = 0; j < w; j++) {
	                ref[i][j] = board[i][j];
	            }
	        }
	        
	        for(int i = 0; i < l; i++) {
	            for(int j = 0; j < w; j++) {
	                liveNeighbors = getLiveNeighborsCount(i, j, l, w, ref);
	                switch(liveNeighbors) {
	                    case 0:
	                    case 1:
	                        board[i][j] = 0;
	                        break;
	                    case 2:
	                        break;
	                    case 3:
	                        if(board[i][j] == 0) {
	                            board[i][j] = 1;
	                        }
	                        break;
	                    default:
	                        board[i][j] = 0;
	                        break;
	                }
	            }
	        }
	    }
	    
	    int getLiveNeighborsCount(int x, int y, int l, int w, int[][] ref) {
	        int liveNeighbors = 0;
	        for(int a = x-1; a < x+2; a++) {
	            for(int b = y-1; b < y+2; b++)  {
	                if(a < 0 || a >= l || b < 0 || b >= w || (a == x && b == y)) {
	                    continue;
	                }
	                liveNeighbors += (ref[a][b] == 1 ? 1 : 0);
	            }
	        }
	        return liveNeighbors;
	    }
}
