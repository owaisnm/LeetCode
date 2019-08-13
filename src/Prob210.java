import java.util.Stack;

public class Prob210 {
	 public int[] findOrder(int numCourses, int[][] prerequisites) {
	        if(numCourses == 0 || prerequisites == null) {
	            return null;
	        } else{
	            int[] order = new int[numCourses];
	            if(numCourses == 1) {
	                order[0] = 0;
	                return order;
	            }

	            boolean [][] matrix = new boolean[numCourses][numCourses];
	            for(int[] p : prerequisites)
	                matrix[p[1]][p[0]] = true;

	            Stack<Integer> stack = new Stack<>();
	            boolean[] visited = new boolean[numCourses];
	            boolean[] recStack = new boolean[numCourses];

	            for(int i = 0; i < numCourses; i++) {
	                if(topSortUsingDFS(stack, visited, recStack, matrix, numCourses, i) == -1)
	                    return new int[0];
	            }
	            
	            // todo: fill order array with stacked courses
	            int count = 0;
	            while(!stack.isEmpty()) {
	                order[count] = stack.pop();
	                count++;
	            }
	            return order;
	        }
	    }
	    
	    int topSortUsingDFS(Stack<Integer> stack, boolean[] visited, boolean[] recStack, boolean[][] matrix, int numCourses, int val) {
	        if(recStack[val])
	            return -1;
	        recStack[val]= true;
	        
	        for(int i = 0; i < numCourses; i++){
	            if(matrix[val][i] && !visited[i]){
	                if(topSortUsingDFS(stack, visited, recStack, matrix, numCourses, i) == -1){
	                    return -1;
	                }
	            }
	        }
	        System.out.println(val);
	        if(!visited[val]) {
	            stack.push(val);
	            visited[val]=true; 
	        }
	        recStack[val]=false;
	        return 1;
	    }
}
