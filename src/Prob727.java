
public class Prob727 {
	// Time complexity: O(n^2)
    // Space complexity: O(1)
    public String minWindow(String S, String T) {
        
        int start, end, wStart, wEnd;
        wStart = wEnd = -1;
        char c, ct, cs;
        int si, ti;
        
        for(int i = 0; i < S.length(); i++) {
            c = S.charAt(i);
            
            // found end
            if(c == T.charAt(T.length() - 1)) {
                end = i;
                si = i;
                ti = T.length() - 1;
                while(si > -1 && ti > -1 && (wEnd == -1 || end - si < wEnd - wStart)) {
                    cs = S.charAt(si);
                    ct = T.charAt(ti);
                    if(cs == ct) {
                        ti--;
                        System.out.println(cs);
                    }
                    si--;
                }
                
                si++;
                ti++;
                if(ti == 0 && (wEnd == -1 || end - si < wEnd - wStart)) {
                    wEnd = end;
                    wStart = si;
                }
            }
        }
        
        return wEnd == -1 ? "" : S.substring(wStart, wEnd + 1);
    }
}
