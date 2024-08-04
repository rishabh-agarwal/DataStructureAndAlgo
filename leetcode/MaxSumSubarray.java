package leetcode;

/**
 * Example input:
 * [4, 2, 1, 7, 8, 1, 2, 8, 1, 0], k=3
 */
public class MaxSumSubarray {
    public static int findMaxSumSubarray(int[] arr, int K){
        int maxValue = Integer.MIN_VALUE;
        int currentSum = 0;

        for(int i =0 ; i< arr.length; i++){
            currentSum += arr[i];
            if(i >= K-1){
                maxValue = Math.max(maxValue, currentSum);
                currentSum -= arr[i - (K - 1)];
            }
        }
        return maxValue;
    }

    public static void main(String[] args){
        System.out.println(findMaxSumSubarray(new int[]{4, 2, 1, 7, 8, 1, 2, 8, 1, 0}, 3));
    }
}
