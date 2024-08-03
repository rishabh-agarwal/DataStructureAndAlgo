package leetcode.practice;

import java.util.*;

class Solution {
        public static boolean validPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                if (s.charAt(left) != s.charAt(right)) {
                    // Try removing the left character or the right character
                    return isPalindrome(s, left + 1, right) || isPalindrome(s, left, right - 1);
                }
                left++;
                right--;
            }
            return true;
        }

        private static boolean isPalindrome(String s, int left, int right) {
            StringBuilder sb = new StringBuilder(s.substring(left, right + 1));
            String reversed = sb.reverse().toString();
            return s.substring(left, right + 1).equals(reversed);
        }

        public static void main(String[] args) {
            System.out.println(validPalindrome("aba")); // true
            System.out.println(validPalindrome("abca")); // true
            System.out.println(validPalindrome("abc")); // false
        }
}
