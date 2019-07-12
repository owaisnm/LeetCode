import java.util.ArrayList;
import java.util.List;

public class Prob229 {
	public List<Integer> majorityElement(int[] nums) {
        
        List<Integer> list = new ArrayList<Integer>();
        if(nums.length == 0) {
            return list;
        } else if(nums.length == 1) {
            list.add(nums[0]);
            return list;
        } else if(nums.length == 2) {
            list.add(nums[0]);
            if(nums[0] == nums[1]) {
                return list;
            }
            list.add(nums[1]);
            return list;
        }
        
        int majority1 = Integer.MIN_VALUE;
        int majority2 = Integer.MIN_VALUE;
        int count1 = 0;
        int count2 = 0;
        
        for(int i = 0; i < nums.length; i++) {
            if(majority1 == Integer.MIN_VALUE) {
                majority1 = nums[i];
                count1 = 1;
            } else if(majority2 == Integer.MIN_VALUE) {
                if(majority1 == nums[i]) {
                    count1++;
                    continue;
                } else {
                    majority2 = nums[i];
                    count2 = 1;
                }
            }
            else if(nums[i] == majority1) {
                count1++;
            } else if(nums[i] == majority2) {
                count2++;
            } else if(count1 == 0) {
                majority1 = nums[i];
                count1 = 1;
            } else if(count2 == 0) {
                majority2 = nums[i];
                count2 = 1;
            } else {
                count1--;
                count2--;
            }
        }
    
        count1 = 0;
        count2 = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == majority1) {
                count1++;
            } else if(nums[i] == majority2) {
                count2++;
            }
        }
        if(count1 > nums.length / 3) {
            list.add(majority1);
        } 
        if(count2 > nums.length / 3) {
            list.add(majority2);
        }
        return list;
    }
}
