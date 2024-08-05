package leetcode;

/**
 * Leetcode 2380.
 */
public class TimeNeededToRearrangeBinaryString {
    public static int secondsToRemoveOccurrences(String s) {
        int seconds = 0;
        while (s.indexOf("01") >= 0) {
            s = s.replace("01", "10");
            ++seconds;
        }
        return seconds;
    }

    public static void main(String[] args) {
        secondsToRemoveOccurrences("0110101");
    }

}
//""
//"0" || "1"
//01

//001011

//1 -> 001011
//2 -> 010011
//3 -> 010011
//4 -> 010101