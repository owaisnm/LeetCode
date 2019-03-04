import java.util.ArrayList;
import java.util.List;

public class Prob784 {
	public List<String> letterCasePermutation(String S) {
        List<String> list = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        return letterCasePermutation(list, S, 0, "");
    }
    
    public List<String> letterCasePermutation(List<String> list, String s, int index, String str) {
        for(int i = index; i < s.length(); i++) {
            if(!Character.isLetter(s.charAt(i))) {
                str += s.charAt(i);
            } else {
                str += Character.toUpperCase(s.charAt(i));
                letterCasePermutation(list, s, i+1, str);
                str = str.substring(0, str.length()-1);
                str += Character.toLowerCase(s.charAt(i));
                letterCasePermutation(list, s, i+1, str);
                return list;
            }
        }
        
        list.add(str);
        return list;
    }
    
}
