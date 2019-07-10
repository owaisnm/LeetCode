import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Prob17 {
    public List<String> letterCombinations(String digits) {
		 // create hashmap relating digits to a string of possible characters
	    // use backtracking to start at any digit, and run through all possible subsequent digits in the given string
	    List<String> possibilities = new ArrayList<String>();
	    if(digits == null || digits.length() == 0) {
	        return possibilities;
	    }
	    HashMap map = new HashMap<Integer, String>();
	    map.put(2, "abc");
	    map.put(3, "def");
	    map.put(4, "ghi");
	    map.put(5, "jkl");
	    map.put(6, "mno");
	    map.put(7, "pqrs");
	    map.put(8, "tuv");
	    map.put(9, "wxyz");
	    
	    letterCombinations(digits, map, possibilities, 0, new StringBuilder());
	    return possibilities;
	}

	void letterCombinations(String digits, HashMap<Integer, String> map, List<String> possibilities, int index, StringBuilder sb) {
	    if(index == digits.length()) {
	        possibilities.add(sb.toString());
	        return;
	    }
	
	    String possibleCharacters = map.get(Character.getNumericValue(digits.charAt(index)));
	    for(int i = 0; i < possibleCharacters.length(); ++i) {
	        sb.append(possibleCharacters.charAt(i));
	        letterCombinations(digits, map, possibilities, index+1, sb);
	        sb.delete(sb.length()-1, sb.length());
	    }
	}
}
