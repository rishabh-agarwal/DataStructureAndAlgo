package leetcode.Array;

import java.util.PriorityQueue;

/*
Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
 */
public class Solution {
    public void sortColors(int[] nums) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        for(int n: nums){
            minHeap.add(n);
        }

        int i= 0;
        while (!minHeap.isEmpty()){
            nums[i++] = minHeap.poll();
        }
    }
}

