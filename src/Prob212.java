import java.util.ArrayList;
import java.util.List;

public class Prob212 {
	public List<String> findWords(char[][] board, String[] words) {
        // create graph
        Node root = new Node();
        Node cursor = root;
        for(String word : words) {
            for(int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int intValue  = (int) c - 97;
                if(cursor.next[intValue] == null) {
                    cursor.next[intValue] = new Node();
                }
                cursor = cursor.next[intValue];                
                cursor.count++;
            }
            cursor.end++;
            cursor = root;
        }
        
        List<String> sol = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        int n = board.length;
        int m = board[0].length;
        boolean[][] visited = new boolean[n][m];
        for(int j = 0; j < n; j++) {
            for(int i = 0; i < m; i++) {
                int intValue  = (int) board[j][i] - 97;
                if(cursor.next[intValue] != null && cursor.next[intValue].count > 0) {
                    sb.append(board[j][i]);
                    if(find(board, sol, j, i, cursor.next[intValue], sb, n, m, visited)) {
                        cursor.next[intValue].count--;
                    }
                    sb.deleteCharAt(sb.length()-1);
                }
            }
        }
        return sol;
    }
    
    boolean find(char[][] board, List<String> sol, int x, int y, Node root, StringBuilder sb, int n, int m, boolean[][] visited) {
        visited[x][y] = true;
        if(root.end > 0) {
            root.count--;
            root.end--;
            
            sol.add(sb.toString());
            visited[x][y] = false;
        }
        
        boolean left = y - 1 > -1 && !visited[x][y-1];
        boolean right = y+1 < m && !visited[x][y+1];
        boolean top = x-1 > -1 && !visited[x-1][y];
        boolean bottom = x+1 < n && !visited[x+1][y];
        int intValue;
        if(left) {
            intValue = (int) board[x][y-1] - 97;
            if(root.next[intValue] != null && root.next[intValue].count > 0) {
                sb.append(board[x][y-1]);
                find(board, sol, x, y-1, root.next[intValue], sb, n, m, visited);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        if(right) {
            intValue = (int) board[x][y+1] - 97;
            if( root.next[intValue] != null && root.next[intValue].count > 0) {
                sb.append(board[x][y+1]);
                find(board, sol,  x, y+1, root.next[intValue], sb, n, m, visited);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        if(top) {
            intValue = (int) board[x-1][y] - 97;
            if( root.next[intValue] != null && root.next[intValue].count > 0) {
                sb.append(board[x-1][y]);
                find(board, sol, x-1, y, root.next[intValue], sb, n, m, visited);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        if(bottom) {
            intValue = (int) board[x+1][y] - 97;
            if( root.next[intValue] != null && root.next[intValue].count > 0) {
                sb.append(board[x+1][y]);
                find(board, sol,x+1, y, root.next[intValue], sb, n, m, visited);
                sb.deleteCharAt(sb.length()-1);
            }
        }
        visited[x][y] = false;
        return false;
    }
    
    class Node {
        Node[] next = new Node[26];
        int count = 0;
        int end = 0;
    }
}
