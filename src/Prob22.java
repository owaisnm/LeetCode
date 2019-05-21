import java.util.ArrayList;
import java.util.List;

public class Prob22 {
	 public List<String> generateParenthesis(int n) {
	        List<String> list = new ArrayList<>();
	        backtrack(list, "", n, 0, 0);
	        return list;
	    }
	    
	     public void backtrack(List<String> list, String string, int n, int open, int close) {
	        if(n == open && n == close) {
	            list.add(string);
	            return;
	        }
	         
	         if(open < n) {
	             backtrack(list, string + "(", n, open + 1, close);
	         }
	         if(open > close) {
	             backtrack(list, string + ")", n, open, close + 1);
	         }
	         return;
	    }
}
