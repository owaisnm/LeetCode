
public class Prob11 {
	public int maxArea(int[] height) {
        // start at first and last indices - compute area
        // move from left to right and right to left
        // if you find height at left that is higher than old left height
        // and a height at right higher than old right height -> check if area is larger
        // continue until you check all higher new heights.

        int maxLeft, maxRight;
        int left, right;
        left = maxLeft = 0;
        right = maxRight = height.length-1;
        int maxArea = (right-left) * (Math.min(height[right], height[left]));
        if(height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
        while(left < right) {
            
            if(height[left] >= height[maxLeft] && height[right] >= height[maxRight]) {
                maxArea = Math.max(maxArea, (right-left) * (Math.min(height[right], height[left])));
                maxLeft = left;
                maxRight = right;
            }
            
            if(height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}
