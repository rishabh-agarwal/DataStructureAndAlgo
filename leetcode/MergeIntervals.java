package leetcode;

import java.util.*;

/**
 * Leetcode: 56
 */
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        // Sort the intervals by their start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];
        for(int i=1; i<intervals.length; i++){
            int[] curr = intervals[i];
            int prevEnd = prev[1];
            int currStart = curr[0];
            int currEnd = curr[1];

            if(prevEnd >= currStart){
                prev[1] = Math.max(prevEnd, currEnd);
            }else{
                merged.add(prev);
                prev = curr;
            }

        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }

    public static void main(String[] args) {
        merge(new int[][]{{1,3}, {2,6}, {8,10}, {15,18}});
    }
}

