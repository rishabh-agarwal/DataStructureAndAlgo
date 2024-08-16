package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode: 17
 */
public class LetterCombinationOfPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        String[] KEYPAD = {
                "",     // 0
                "",     // 1
                "abc",  // 2
                "def",  // 3
                "ghi",  // 4
                "jkl",  // 5
                "mno",  // 6
                "pqrs", // 7
                "tuv",  // 8
                "wxyz"  // 9
        };

        List<String> result = new ArrayList<>();
        if(digits == null || digits.isEmpty()){
            return result;
        }

        result.add("");
        for(char digit: digits.toCharArray()){
            String letters = KEYPAD[digit - '0'];
            List<String> newCombinations = new ArrayList<>();
            for(String combination: result){
                for (char letter : letters.toCharArray()) {
                    newCombinations.add(combination + letter);
                }
            }
            result = newCombinations;
        }
        return result;
    }
    public static void main(String[] args) {
        System.out.println(letterCombinations("234")); // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinations("23")); // Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]
        System.out.println(letterCombinations(""));   // Output: []
        System.out.println(letterCombinations("2"));  // Output: ["a","b","c"]
    }
}

