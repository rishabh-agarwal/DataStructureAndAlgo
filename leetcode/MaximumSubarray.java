package leetcode;
/*
Question 53 - Medium
Example 1:

Input: nums = [-2,1,-3,4,-1,2,1,-5,4]
Output: 6
Explanation: The subarray [4,-1,2,1] has the largest sum 6.
Example 2:

Input: nums = [1]
Output: 1
Explanation: The subarray [1] has the largest sum 1.
Example 3:

Input: nums = [5,4,-1,7,8]
Output: 23
Explanation: The subarray [5,4,-1,7,8] has the largest sum 23.
 */

public class MaximumSubarray {
    public static int maxSubArray(int[] nums) {
        int maxSum = Integer.MIN_VALUE;

        for(int start=0; start<nums.length; start++){
            int currentSum = 0;
            for(int end=start+1; end<nums.length; end++){
                currentSum+= nums[end];
                if(currentSum>maxSum) {
                    maxSum = Math.max(currentSum, maxSum);
                }
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}
