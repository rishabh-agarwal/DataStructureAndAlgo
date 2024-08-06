package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class MeetingScheduler {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {

        PriorityQueue<int[]> pq1 = new PriorityQueue<>((a,b)->(Integer.compare(a[0],b[0])));
        PriorityQueue<int[]> pq2 = new PriorityQueue<>((a,b)->(Integer.compare(a[0],b[0])));

        for(int[] slot : slots1)
            pq1.add(slot);

        for(int[] slot : slots2)
            pq2.add(slot);

        while(!pq1.isEmpty() && !pq2.isEmpty()){
            int[] person1 = pq1.peek();
            int[] person2 = pq2.peek();
            //get the intersected starting time
            int start = Math.max(person1[0],person2[0]);
            int end = start+duration;
            //check if we can fit the end time in the intersected time
            if(end <= person1[1] && end <= person2[1])
                return List.of(start,end);
            //simply remove the entry if we cannot accommodate the meeting in either of the
            //free time then remove the entry from the respective persons
            if(end > person1[1])
                pq1.poll();
            if(end > person2[1])
                pq2.poll();
        }
        return new ArrayList<>();
    }
}
