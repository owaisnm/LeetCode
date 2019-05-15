import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Prob535 {
	public static final String BASE_URL = "http://tinyurl.com/";
    Map<String, String> map = new HashMap<>();
    
    public String generateRandomString() {
        byte[] array = new byte[7]; 
        new Random().nextBytes(array);
        return new String(array, java.nio.charset.Charset.forName("UTF-8"));
    }
    
    public String encode(String longUrl) {
        String shortUrl = BASE_URL+generateRandomString();
        while(map.containsKey(shortUrl)) {
            shortUrl = BASE_URL+generateRandomString();
        }
        map.put(shortUrl, longUrl);
        return shortUrl;
    }

    public String decode(String shortUrl) {
        return map.get(shortUrl);
    }
}
