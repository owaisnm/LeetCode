
public class Prob48 {
public void rotate(int[][] matrix) {
        
        int tmp;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix.length/2; j++) {
                tmp = matrix[j][i];
                matrix[j][i] = matrix[matrix.length-1-j][i];
                matrix[matrix.length-1-j][i] = tmp;
            }
        }
        
        for(int i = 0; i < matrix.length; i++){
            for(int j = i; j < matrix[i].length; j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }
}
