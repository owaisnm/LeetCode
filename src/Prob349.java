import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class Prob349 {
	public int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
    
        Set<Integer> set = new HashSet<>();
        int ind1, ind2;
        ind1 = ind2 = 0;
        while(ind1 < nums1.length && ind2 < nums2.length) {
            if(nums1[ind1] == nums2[ind2]) {
                set.add(nums1[ind1]);
            } 
            
            if(nums1[ind1] < nums2[ind2]) {
                ind1++;
            } else {
                ind2++;
            }
        }
        
        int[] sol = new int[set.size()];
        int ind = 0;
        Iterator<Integer> it = set.iterator();
        while(it.hasNext()) {
            sol[ind] = it.next();
            ind++;
        }
        return sol;
    }
}
