
public class Prob165 {
	public int compareVersion(String version1, String version2) {
        int i, j, val1, val2;
        String v1, v2;
        v1 = v2 = null;
        i = j = 0;
        val1 = val2 = 0;
        while(i < version1.length() || j < version2.length()) {
            // System.out.println(version1.indexOf('.', i) + "  " + version2.indexOf('.', j));
            if(version1.indexOf('.', i) > -1) {
                v1 = version1.substring(i, version1.indexOf('.', i));
                i += v1.length();
                i++;
            } else {
                v1 = version1.substring(i, version1.length());
                i += v1.length();
            }
            if(version2.indexOf('.', j) > -1) {
                v2 = version2.substring(j, version2.indexOf('.', j));
                j += v2.length();
                j++;
            } else {
                v2 = version2.substring(j, version2.length());
                j += v2.length();
            }
            if(v1.equals("")) v1 = null;
            if(v2.equals("")) v2 = null;
            if(v1 == null && v2 == null) {
                return 0;
            }
            val1 = v1 == null ? 0 : Integer.valueOf(v1);
            val2 = v2 == null ? 0 : Integer.valueOf(v2);
            if(val1 == val2) {
                v1 = v2 = null;
                continue;
            } else if(val1 < val2) {
                return -1;
            } else {
                return 1;
            }
        }
        return 0;
    }
}
