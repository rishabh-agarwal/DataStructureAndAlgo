package leetcode;

import java.util.*;

/**
 * Leetcode: 56
 */
public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];
        for(int i=1; i<intervals.length; i++){
            int[] curr = intervals[i];
            if(prev[1] >= curr[0]){
                prev[1] = Math.max(prev[1], curr[1]);
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

