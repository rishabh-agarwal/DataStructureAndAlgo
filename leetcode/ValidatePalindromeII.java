package leetcode;

/**
 * Leetcode: 680
 */
public class ValidatePalindromeII {
    public static boolean validPalindrome(String s) {
        int left = 0;
        int right = s.length()-1;

        while(left<right){
            if(s.charAt(left)==s.charAt(right)){ // a = a
                left ++;
                right --;
            }
            else return (palindromHelper(s, left+1, right) || palindromHelper(s, left, right-1));
        }
        return true;
    }
     public static boolean palindromHelper(String s, int left, int right){
        while(left<=right){
            if(s.charAt(left)==s.charAt(right)){
                left++;
                right--;
            }
            else return false;
        }
        return true;
     }

    //abc -> true
    //abca -> true

    public static void main(String[] args) {
        validPalindrome("aba");
    }
}
