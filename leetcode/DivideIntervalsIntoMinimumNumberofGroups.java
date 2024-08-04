package leetcode;

import java.util.*;

public class DivideIntervalsIntoMinimumNumberofGroups {

    public static int minGroups(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0])
                .thenComparingInt(a -> a[1]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(0);

        for(int[] arr:intervals){
            int start=arr[0];
            int end=arr[1];
            int prev=pq.peek();
            if(start>prev){
                pq.poll();
            }
            pq.add(end);
        }
        return pq.size();
    }

    public static void main(String[] args) {
        System.out.println(minGroups(new int[][]{{5, 10}, {6, 8}, {1, 5}, {2, 3}, {1, 10}}));
    }
}
