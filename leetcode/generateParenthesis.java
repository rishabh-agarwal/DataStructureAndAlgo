package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * Generate Parenthesis : Leetcode 22
 */
public class generateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> output = new ArrayList<>();
        backtracking(output, "", 0,0, n);
        return output;
    }

    public void backtracking(List<String> output, String currentString, int open, int close, int max){
        if(currentString.length()==max*2){
            output.add(currentString);
            return;
        }
        if(open<max){
            backtracking(output, currentString+"(", open+1, close, max);
        }
        if(close<open){
            backtracking(output, currentString+")", open, close+1, max);
        }
    }
}
