package leetcode;

import java.util.Arrays;

/**
 * Leetcode 1589
 */
public class MaximumSumAnyPermutation {
    public static int maxSumRangeQuery(int[] nums, int[][] requests) {
        int MOD = 1000000007;
        int n = nums.length;
        int[] freq = new int[n];

        // Process each request to build the freq array
        for (int[] request : requests) {
            int start = request[0];
            int end = request[1];
            for(int i=start; i<=end; i++){
                freq[i]++;
            }
        }

        // Sort the nums array and freq array
        Arrays.sort(nums);
        Arrays.sort(freq);

        // Calculate the maximum sum by pairing largest elements with highest frequencies
        long maxSum = 0;
        for (int i = 0; i < n; i++) {
            maxSum += ((long) nums[i] * freq[i]) % MOD;
        }

        return (int) maxSum;
    }

    public static void main(String[] args) {
        maxSumRangeQuery(new int[]{1,2,3,4,5}, new int[][]{{1,3},{0,1}});
    }
}