package leetcode;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Leetcode: 347
 */
public class TopKFrequentElements {
    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num: nums){
            map.put(num, map.getOrDefault(num,0)+1);
        }

        PriorityQueue<Map.Entry<Integer, Integer>> minHeap=
            new PriorityQueue<>(Comparator.comparingInt(Map.Entry::getValue));

        for(Map.Entry<Integer, Integer> entry: map.entrySet()){
            minHeap.add(entry);
            if(minHeap.size()>k)
                minHeap.poll();
        }

        int[] res = new int[k];
        int i=0;
        while (i<k){
            res[i++] = minHeap.poll().getKey();
        }
        return res;
    }

    public static void main(String[] args) {
        topKFrequent(new int[]{1,1,1,2,2,2,3}, 2);
    }
}
