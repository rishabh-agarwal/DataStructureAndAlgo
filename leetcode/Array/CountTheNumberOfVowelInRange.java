package leetcode.Array;

/**
 * LeetCode: 2586
 */
public class CountTheNumberOfVowelInRange {
    public int vowelStrings(String[] words, int left, int right) {
        int count = 0;
        for(int i = left;i <= right;i++)
        {
            String s = words[i];
            int a = s.length() - 1;
            if((s.charAt(0) == 'a' || s.charAt(0) == 'e' || s.charAt(0) == 'i' || s.charAt(0) == 'o' || s.charAt(0) == 'u') && (s.charAt(a) == 'a' || s.charAt(a) == 'e' || s.charAt(a) == 'i' || s.charAt(a) == 'o' || s.charAt(a) == 'u'))
            {
                count++;
            }
        }
        return count;
    }
}

// loop will start from left -> right (increment by one)
// get the first and last character and check vowel
// if vowel increase the count and return result