
public class Prob88 {
	//T: O(n)
    //S: O(1);
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        
        if(n == 0) {
            return;
        }
        
        int ind1, ind2;
        ind1 = m-1;
        ind2 = n-1;
        int k = m+n-1;
        
        while(ind1 >= 0 && ind2 >= 0) {
            if(nums1[ind1] > nums2[ind2]) {
                nums1[k] = nums1[ind1];
                System.out.print(nums1[k]);
                ind1--;
                k--;
            } else {
                nums1[k] = nums2[ind2];
                System.out.print(nums1[k]);
                ind2--;
                k--;
            }
        }        
        if(ind1 >= 0) {
            while(ind1 >= 0) {
                nums1[k] = nums1[ind1];
                k--;
                ind1--;   
            }
        } else if(ind2 >= 0) {
            while(ind2 >= 0) {
                nums1[k] = nums2[ind2];
                k--;
                ind2--;   
            }
        }
    }
}
