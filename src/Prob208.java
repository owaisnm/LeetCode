
public class Prob208 {
	class Trie {

	    Node[] nodes;
	    
	    /** Initialize your data structure here. */
	    public Trie() {
	        nodes = new Node[26];
	    }
	    
	    /** Inserts a word into the trie. */
	    public void insert(String word) {
	        Node[] list = nodes;
	        for(int i = 0; i < word.length(); i++) {
	            if(list[word.charAt(i) - 97] != null) {
	                if(list[word.charAt(i) - 97].children == null) {
	                    list[word.charAt(i) - 97].children = new Node[26];
	                }
	                list = list[word.charAt(i) - 97].children;
	            } else {
	                list[word.charAt(i) - 97] = new Node(false, new Node[26]);
	                list = list[word.charAt(i) - 97].children;
	            }
	        }
	        if(list[word.charAt(word.length()-1) - 97] == null) {
	            list[word.charAt(word.length()-1) - 97] = new Node(true, null);
	        } else {
	            list[word.charAt(word.length()-1) - 97].flag = true;
	        }
	    }
	    
	    /** Returns if the word is in the trie. */
	    public boolean search(String word) {
	        Node[] list = nodes;
	        for(int i = 0; i < word.length(); i++) {
	            if(list[word.charAt(i) - 97] != null && list[word.charAt(i) - 97].children != null) {
	                list = list[word.charAt(i) - 97].children;
	            } else {
	                return false;
	            }
	        }
	        return list[word.charAt(word.length()-1) - 97] != null && list[word.charAt(word.length()-1) - 97].flag;
	    }
	    
	    /** Returns if there is any word in the trie that starts with the given prefix. */
	    public boolean startsWith(String prefix) {
	       Node[] list = nodes;
	        for(int i = 0; i < prefix.length(); i++) {
	            if(list[prefix.charAt(i) - 97] != null && list[prefix.charAt(i) - 97].children != null) {
	                list = list[prefix.charAt(i) - 97].children;
	            } else {
	                return false;
	            }
	        }
	        return true;
	    }
	    
	    class Node {
	        boolean flag;
	        Node[] children;
	        
	        Node(boolean flag, Node[] children) {
	            this.flag = flag;
	            this.children = children;
	        }
	    }
	}
}
