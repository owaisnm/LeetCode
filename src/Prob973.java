import java.util.Arrays;

public class Prob973 {
	 public int[][] kClosest(int[][] points, int K) {
	        
	        Arrays.sort(points, new java.util.Comparator<int[]>() {
	            public int compare(int[] a, int[] b) {
	                return Double.compare(distanceFromOrigin(a), distanceFromOrigin(b));
	            }
	        });
	        
	        int[][] result = new int[K][2];
	        for(int i = 0; i < K; i++) {
	            result[i][0] = points[i][0];
	            result[i][1] = points[i][1];
	        }
	        return result;
	    }
	    
	    private double distanceFromOrigin(int[] point) {
	        return Math.sqrt(point[0] * point[0] + point[1]*point[1]);
	    }
}
