import java.util.HashMap;
import java.util.Map;

public class Prob359 {
	class Logger {

	    Map<String, Integer> map;
	    /** Initialize your data structure here. */
	    public Logger() {
	        map = new HashMap<>();
	    }
	    
	    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
	        If this method returns false, the message will not be printed.
	        The timestamp is in seconds granularity. */
	    public boolean shouldPrintMessage(int timestamp, String message) {
	        Integer prevTimestamp = map.get(message);
	        if(prevTimestamp == null) {
	            map.put(message, timestamp);
	            return true;
	        } else {
	            if(timestamp - prevTimestamp.intValue() < 10) {
	                return false;
	            } else {
	                map.put(message, timestamp);
	                return true;
	            }
	        }
	    }
	}
}
