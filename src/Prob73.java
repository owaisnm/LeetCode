
public class Prob73 {
	public void setZeroes(int[][] matrix) {
		if(matrix != null && matrix.length > 0) {
			int m = matrix.length;
			int n = matrix[0].length;
			
			print(matrix, m, n);
			boolean[][] zeros = new boolean[m][n];
		
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if(matrix[i][j] == 0) {
						zeros[i][j] = true;
					}
				}
			}	
			
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if(zeros[i][j]) {
						setZeros(matrix, m, n, i, j);
					}
				}
			}	
			
			print(matrix, m, n);
		}
	}
	
	public void setZeros(int[][] matrix, int m, int n, int x, int y) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if(i == x || j == y) {
					matrix[i][j] = 0;
				}
			}
		}	
	}

	public void print(int[][] matrix, int m, int n) {
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}
}
