package leetcode;

import java.util.*;

/**
 * Leetcode 179
 */
public class LargestNumber {
    private class LargerNumberComparaotr implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            String order1 = a + b;
            String order2 = b + a;
            return order2.compareTo(order1);
        }
    }

    public String largestNumber(int[] nums) {
        String[] arr = new String[nums.length];
        for (int i = 0; i < nums.length; i++) {
            arr[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(arr, new LargerNumberComparaotr());

        if (Integer.valueOf(arr[0]) == 0)
            return "0";

        String largestString = new String();
        for (String s : arr) {
            largestString += s;
        }

        return largestString;
    }
}
