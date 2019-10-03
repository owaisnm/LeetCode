
public class HasLetters {

	boolean hasLetters(String word, char[] characters) {
		
		int[] arr = new int[26];
		for(int i = 0; i < word.length(); i++)
			arr[word.charAt(i) - 'a']++;
		
		for(int i = 0; i < characters.length; i++) {
			if(arr[characters[i] - 'a'] > 0)
				arr[characters[i] - 'a']--;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i] > 0) {
				return false;
			}
		}
		return true;
	}
}
