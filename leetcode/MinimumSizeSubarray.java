package leetcode;

/**
 * LC: 209
 * Minimum size subarray sum
 */
public class MinimumSizeSubarray {
    public static int minSubArrayLen(int target, int[] nums) {
        int currentSum = 0;
        int minimumSize = Integer.MAX_VALUE;
        int windowStar =0;
        for(int windowEnd = 0; windowEnd<nums.length; windowEnd++){
            currentSum += nums[windowEnd];
            while (currentSum>=target){
                minimumSize = Math.min(minimumSize, windowEnd-windowStar+1);
                currentSum -= nums[windowStar];
                windowStar++;
            }
        }
        if(minimumSize == Integer.MAX_VALUE)
            return 0;
        return minimumSize;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(11,new int[] {1,1,1,1,1,1,1,1}));
        System.out.println(minSubArrayLen(7,new int[] {2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(4,new int[] {1,4,4}));

    }
}
