import java.util.Stack;

public class Prob20 {

    public boolean isValid(String s) {
        char[] openMatches = new char[] {'(', '[', '{'};
        char[] closedMatches = new char[] {')', ']', '}'};
        Stack<Character> stack = new Stack<>();
        
        for(int i = 0; i < s.length(); i++) {
            int openParanIndex = getParanIndex(openMatches, s.charAt(i));
            int closedParanIndex = getParanIndex(closedMatches, s.charAt(i));
            
            if(!stack.isEmpty())  {
                if(closedParanIndex > -1) {
                    if(stack.peek() == openMatches[closedParanIndex]) {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    stack.push(openMatches[openParanIndex]);
                }
            } else if(closedParanIndex > -1) {
                return false;
            } else if(openParanIndex > -1) {
                stack.push(openMatches[openParanIndex]);
            }
        }
        return stack.isEmpty();
    }
    
    int getParanIndex(char[] matches, char c) {
        for(int i = 0; i < matches.length; i++) {
            if(matches[i] == c) {
                return i;
            }
        }
        return -1;
    }
}
