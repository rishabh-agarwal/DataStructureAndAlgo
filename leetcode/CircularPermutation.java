package leetcode;

import java.util.ArrayList;
import java.util.List;

public class CircularPermutation {
    public static List<Integer> circularPermutation(int n, int start) {
        List<Integer> res = new ArrayList<>();
        for(int i=0; i < Math.pow(2, n); i++) {
            res.add(start ^ i ^ (i >> 1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(circularPermutation(2, 3));
    }
}


//n=2, start=3

