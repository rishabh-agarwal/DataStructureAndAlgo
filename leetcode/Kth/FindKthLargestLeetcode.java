package leetcode.Kth;

import java.util.PriorityQueue;

/**
 * Leetcode 215
 */
public class FindKthLargestLeetcode {
    public int findKthLargest(int[] nums, int k) {
        int result=0;
        PriorityQueue queue = new PriorityQueue();

        for(int i=0; i< nums.length; i++){
            queue.add(nums[i]);
        }

        int i=0;
        while(i<=k){
            if(i==k)
                result = nums[i];
        }
        return result;
    }
}
