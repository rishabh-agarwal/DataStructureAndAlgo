package leetcode;

import java.util.Arrays;

/**
 * Leetcode 1589
 */
public class MaximumSumAnyPermutation {
    public static int maxSumRangeQuery(int[] nums, int[][] requests) {
        int mod = 1000000007;
        int[] overlap = new int[nums.length];

        for (int[] range : requests) {
            overlap[range[0]]++;
            if (range[1]+1 < nums.length)
                overlap[range[1]+1]--;
        }

        for (int i=1; i<overlap.length; i++)
            overlap[i] += overlap[i-1];

        Arrays.sort(nums);
        Arrays.sort(overlap);

        long sum = 0;
        int idx = nums.length - 1;
        for (int i= overlap.length -1; i>=0; i--) {
            sum = sum % mod + ((long) overlap[i] * nums[idx--]) % mod;
        }
        return (int) (sum + mod) % mod;
    }

    public static void main(String[] args) {
        maxSumRangeQuery(new int[]{1,2,3,4,5}, new int[][]{{1,3},{0,1}});
    }
}