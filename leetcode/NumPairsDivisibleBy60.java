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
        numPairsDivisibleBy60(new int[]{30,20,150,100,40});
    }
}
