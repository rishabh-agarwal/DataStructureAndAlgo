package leetcode.Array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Leetcode 1002: Find Common Characters
 */
public class FindCommonCharacter {
    public List<String> commonChars(String[] words){
        Map<Character, Integer> countMap = new HashMap<>();
        for (char c : words[0].toCharArray()) {
            countMap.put(c, countMap.getOrDefault(c, 0) + 1);
        }

        // Iterate through the rest of the words
        for (String word : words) {
            Map<Character, Integer> currentCountMap = new HashMap<>();
            for (char c : word.toCharArray()) {
                currentCountMap.put(c, currentCountMap.getOrDefault(c, 0) + 1);
            }

            // Update the countMap to retain the minimum counts
            for (char c : countMap.keySet()) {
                if (currentCountMap.containsKey(c)) {
                    countMap.put(c, Math.min(countMap.get(c), currentCountMap.get(c)));
                } else {
                    countMap.put(c, 0);
                }
            }
        }

        // Collect the common characters
        List<String> result = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : countMap.entrySet()) {
            for (int i = 0; i < entry.getValue(); i++) {
                result.add(String.valueOf(entry.getKey()));
            }
        }

        return result;
    }
}

