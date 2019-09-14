import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Prob981 {
	class TimeMap {
	    
	    Map<String, TreeMap<Integer, String>> map;

	    /** Initialize your data structure here. */
	    public TimeMap() {
	        map = new HashMap<>();
	    }
	    
	    public void set(String key, String value, int timestamp) {
	        
	        TreeMap<Integer, String> tMap = map.get(key);
	        if(tMap == null) {
	            tMap = new TreeMap<>();
	        }
	        tMap.put(timestamp, value);
	        map.put(key, tMap);
	    }
	    
	    public String get(String key, int timestamp) {
	        TreeMap<Integer, String> tMap = map.get(key);
	        if(tMap != null) {
	            if(tMap.get(timestamp) != null) {
	                return tMap.get(timestamp);
	            } else if(tMap.floorEntry(timestamp) != null) {
	                return tMap.floorEntry(timestamp).getValue();
	            }
	        }

	        return "";
	    }
	}
}
