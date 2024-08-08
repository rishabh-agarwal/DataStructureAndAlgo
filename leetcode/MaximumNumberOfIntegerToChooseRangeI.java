package leetcode;

import java.util.HashSet;

/**
 * Leetcode: 2554
 */
public class MaximumNumberOfIntegerToChooseRangeI {
    public int maxCount(int[] banned, int n, int maxSum) {
        HashSet<Integer> set = new HashSet<>();
        int res = 0;
        for(int i: banned){
            set.add(i);
        }

        for(int i=1; i<=n; i++){
            if(!set.contains(i)){
                if(maxSum<i)
                    break;
                maxSum -= i;
                res++;
            }
        }
        return res;
    }
}
