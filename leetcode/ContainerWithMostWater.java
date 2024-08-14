package leetcode;

/**
 * Leetcode: 11
 */
public class ContainerWithMostWater {
    public static int maxArea(int[] height){
        int left = 0;
        int right = height.length-1;

        int maxArea = 0;

        while(left<right){
            int sum = (right - left) * (Math.min(height[left], height[right]));
            maxArea = Math.max(sum, maxArea);

            if(height[left] < height[right])
                left ++;
            else
                right--;
        }

        return maxArea;
    }

    public static void main(String[] args) {
        maxArea(new int[]{1,8,6,2,5,4,8,3,7});
    }
}
