package leetcode.Array;

import java.util.Arrays;

/**
 * Leetcode 2559
 * Count vowel Strings in Ranges
 */

public class CountVowelStringsRangeII {
    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] res = new int[queries.length];
        Arrays.fill(res, 0);

        for(int i=0; i< queries.length; i++){

            int[] query = queries[i];
            int start = query[0];
            int end = query[1];

            for(int j=start; j<=end; j++){
                if(isStringVowel(words[j])){
                    res[i] += 1;
                }
            }

        }

        return res;
    }

    public static boolean isStringVowel(String s) {
        char firstChar = s.charAt(0);
        char lastChar = s.charAt(s.length() - 1);
        return isVowel(firstChar) && isVowel(lastChar);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}
