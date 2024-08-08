package leetcode;

import java.util.HashMap;
import java.util.Map;

/*
Leetcode 1010: Pairs of Songs With Total Durations Divisible by 60
 */
public class NumPairsDivisibleBy60 {
    public static int numPairsDivisibleBy60(int[] time) {
        Map<Integer, Integer> map = new HashMap<>();
        int ans=0;
        for(int t: time){
            int mod = t % 60;
            int rem = (mod == 0)? 0 : 60 - mod;
            ans += map.getOrDefault(rem, 0);
            map.put(mod, 1 + map.getOrDefault(mod, 0));
        }

        return ans;
    }

    public static void main(String[] args) {
        numPairsDivisibleBy60(new int[]{60,60,60});
    }
}

// Brute Force Approach -> using 2 For - Loops -> TLE
// Time: O(N^2) & Space: O(1)
/*public int numPairsDivisibleBy60(int[] time) {

    int count = 0;
    for(int i = 0; i < time.length; i++){
        for(int j = i+1; j < time.length; j++) {
            if((time[i] + time[j]) % 60 == 0)
                count++;
        }
    }
    return count;
}*/
