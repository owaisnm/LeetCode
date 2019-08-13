
public class Prob207 {
	public boolean canFinish(int numCourses, int[][] prerequisites) {
	        
	        // create adjacency matrix
	        // use dfs to check if we can finish all courses
	        // if any next node has been visited before, a cycle exists
	        boolean[][] matrix = new boolean[numCourses][numCourses];
	        for(int[] prereq : prerequisites) {
	            matrix[prereq[1]][prereq[0]] = true;
	        }
	        
	        //print 
	        for(int i = 0; i< numCourses; i++) {
	            for(int j = 0; j < numCourses; j++) {
	                if(matrix[i][j]) {
	                }
	            }
	        }
	     
	        boolean[] recStack= new boolean[numCourses];
	        boolean[] visited = new boolean[numCourses];
	        for(int i = 0; i < numCourses; i++){
	            if(dfs(recStack,visited, matrix, numCourses, i) == -1) {
	                return false;
	            }
	        }        
	        return true;
	    }
	    
	    int dfs(boolean[] recStack, boolean[] visited, boolean[][] matrix, int numCourses, int val) {
	        if(recStack[val]) {
	            return -1;
	        }
	        recStack[val]=true;
	        for(int i = 0; i < numCourses; i++) {
	            if(matrix[val][i] && !visited[i]){
	                if(dfs(recStack, visited, matrix, numCourses, i) == -1) {
	                    return -1;
	                }
	            }
	        }
	        visited[val] = true;
	        recStack[val]=false;
	        return 1;
	    }
}
