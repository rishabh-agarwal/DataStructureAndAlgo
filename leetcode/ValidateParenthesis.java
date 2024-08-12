package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * Leetcode 20
 */
public class ValidateParenthesis {

    public static boolean isValid(String s) {
        char[] arr = s.toCharArray();

        Map<Character, Character> map = new HashMap<>();
        map.put('{','}');
        map.put('(',')');
        map.put('[',']');

        Stack<Character> stack = new Stack<>();

        for(char c: arr){
            if(!stack.isEmpty() && map.get(stack.peek()) == c)
                stack.pop();
            else if(map.containsKey(c))
                stack.push(c);
        }

        if(stack.isEmpty())
            return true;
        else
            return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("([)]"));
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));
        System.out.println(isValid("(]"));
    }
}
