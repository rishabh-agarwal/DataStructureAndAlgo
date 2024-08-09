package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/*
Leetcode: 767
 */
public class ReorganizeString {
    public static String reorganizeString(String s){
        // Step 1: Count the frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (char c : s.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }

        // Step 2: Create a max-heap (priority queue) based on the character frequency
        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a));
        maxHeap.addAll(frequencyMap.keySet());

        // Step 3: Build the result string by placing the most frequent character first
        StringBuilder result = new StringBuilder();
        while (maxHeap.size() > 1) {
            // Extract the two most frequent characters
            char first = maxHeap.poll();
            char second = maxHeap.poll();

            // Append them to the result string
            result.append(first);
            result.append(second);

            // Decrease their frequency and add them back to the heap if they are still needed
            frequencyMap.put(first, frequencyMap.get(first) - 1);
            frequencyMap.put(second, frequencyMap.get(second) - 1);

            if (frequencyMap.get(first) > 0) {
                maxHeap.offer(first);
            }
            if (frequencyMap.get(second) > 0) {
                maxHeap.offer(second);
            }
        }

        // Step 4: Handle the last remaining character
        if (!maxHeap.isEmpty()) {
            char last = maxHeap.poll();
            if (frequencyMap.get(last) > 1) {
                return "";  // Not possible to rearrange
            }
            result.append(last);
        }

        return result.toString();
    }

    public static void main(String[] args) {
        reorganizeString("aaab");
    }
}
