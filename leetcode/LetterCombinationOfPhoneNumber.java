package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Leetcode: 17
 */
public class LetterCombinationOfPhoneNumber {

    public static List<String> letterCombinations(String digits) {
        if(digits == null || digits.isEmpty()) return new ArrayList<>();
       String[] keypad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
       List<String> result = new ArrayList<>();
       result.add("");

       for(char c: digits.toCharArray()){ //Iterating 1 digit over time eg: 3 time (2 -> abc)
           char[] letters = keypad[c - '0'].toCharArray(); //eg: abc, def
           List<String> newCombination = new ArrayList<>();
           for(String res: result){
               for(char letter : letters){ //3 time
                   newCombination.add(res + letter);
               }
           }
           result = newCombination;
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

