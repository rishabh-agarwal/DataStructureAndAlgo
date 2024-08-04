package leetcode;

import java.util.HashSet;
import java.util.Set;

/*
Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

 */
public class LongestWithoutRepeatingCharacter {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int maxLength = Integer.MIN_VALUE;
        int left = 0;
        Set<Character> charSet = new HashSet<>();

        for(int right=0; right<n; right++){
            if(!charSet.contains(s.charAt(right))){
                charSet.add(s.charAt(right));
                maxLength = Math.max(maxLength, right - left +1);
            }else{
                while (charSet.contains(s.charAt(right))){
                    charSet.remove(s.charAt(right));
                    left++;
                }
                charSet.add(s.charAt(right));
            }
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
