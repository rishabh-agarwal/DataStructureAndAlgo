package leetcode;

import java.util.HashSet;
import java.util.Set;

/**
 * Leetcode: 2062
 */
public class CountVowelSubstringsOfAString {
    public static int countVowelSubstrings(String word) {
        int count = 0;
        Set<Character> substringSet = new HashSet<>();
        Set<Character> vowelSet = Set.of('a','e','i','o','u');


        for(int left=0; left<word.length(); left++){
            substringSet.clear();
            for (int right=left; right<word.length(); right++){
                if(vowelSet.contains(word.charAt(right))){
                   substringSet.add(word.charAt(right));
                   if(substringSet.size()==5){
                       count++;
                   }
                }
                else
                    break;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        countVowelSubstrings("aeiouu");
    }
}
