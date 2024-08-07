package leetcode;

import java.util.HashMap;

/**
 * LeetCode: 6
 */

public class ZigZagConversion {
    public static String convert(String s, int numRows) {
        // Special case: if numRows is 1, the zigzag pattern is the same as the original string
        if (numRows == 1) return s;

        // Initialize a HashMap to store StringBuilder objects for each row
        HashMap<Integer, StringBuilder> map = new HashMap<>();
        for (int i = 0; i < numRows; i++) {
            map.put(i, new StringBuilder());
        }

        // Initialize the row pointer and the direction flag
        int rowPtr = 0;
        boolean goingDown = false;

        // Iterate through each character in the input string
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            // Append the current character to the appropriate row
            map.get(rowPtr).append(c);

            // If we reach the top or bottom row, reverse the direction
            if (rowPtr == 0 || rowPtr == numRows - 1) {
                goingDown = !goingDown;
            }

            // Move the row pointer up or down based on the current direction
            rowPtr += goingDown ? 1 : -1;
        }

        // Combine all rows to form the final result
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            result.append(map.get(i).toString());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        convert("PAYPALISHIRING", 3);
    }
}
