import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Prob341 {
	  public interface NestedInteger {
	      // @return true if this NestedInteger holds a single integer, rather than a nested list.
	      public boolean isInteger();
	 
	      // @return the single integer that this NestedInteger holds, if it holds a single integer
	      // Return null if this NestedInteger holds a nested list
	      public Integer getInteger();
	 
	      // @return the nested list that this NestedInteger holds, if it holds a nested list
	      // Return null if this NestedInteger holds a single integer
	      public List<NestedInteger> getList();
	  }
	 
	public class NestedIterator implements Iterator<Integer> {
	    LinkedList<Integer> queue;
	    int i;
	    
	    public NestedIterator(List<NestedInteger> nestedList) {
	        queue = new LinkedList<>();
	        populate(queue, nestedList);
	        i = 0;
	    }
	    
	    void populate(LinkedList<Integer> queue, List<NestedInteger> nestedList) {
	       for(NestedInteger nested : nestedList) {
	           if(nested.isInteger()) {
	               queue.add(nested.getInteger());
	           } else {
	               populate(queue, nested.getList());
	           }
	       }
	    }

	    @Override
	    public Integer next() {
	        return queue.poll();
	    }

	    @Override
	    public boolean hasNext() {
	        return !queue.isEmpty();
	    }
	}
}
