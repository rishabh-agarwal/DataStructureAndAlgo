package leetcode.SlidingWindow;

/**
 * Leetcode: 208
 */
public class SmallestSubarrayWithGivenSum {
    public static int smallestSubarray(int targetSum, int[] arr){
        int minWindowSize = Integer.MAX_VALUE;
        int currentSum = 0;
        int windowStart = 0;
        for(int windowEnd = 0; windowEnd<arr.length; windowEnd++){
            currentSum += arr[windowEnd];
            while(currentSum >= targetSum){
                minWindowSize = Math.min(minWindowSize, windowEnd-windowStart +1);
                currentSum -= arr[windowStart];
                windowStart++;
            }
        }
        return minWindowSize;
    }

    public static void main(String[] args){
        int[] input = new int[]{4,2,2,7,8,1,2,8,10};
        int targetSum = 8;
        System.out.println(smallestSubarray(8, input));
    }
}
