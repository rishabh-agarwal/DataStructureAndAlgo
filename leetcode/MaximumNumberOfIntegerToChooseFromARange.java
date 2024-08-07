package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode: 2554
 */
public class MaximumNumberOfIntegerToChooseFromARange {
    public static int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < banned.length; i++) {
            set.add(banned[i]);
        }
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if(!set.contains(i)){
                if(maxSum<i){
                    break;
                }
                maxSum = maxSum - i;
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        maxCount(new int[]{1,6,5}, 5, 6);
    }
}
