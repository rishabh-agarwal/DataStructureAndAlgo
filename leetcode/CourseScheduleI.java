package leetcode;

import java.util.*;

/**
 * Leetcode 207
 */
public class CourseScheduleI {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        // Create an adjacency list to represent the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            adjList.add(new ArrayList<>());
        }

        // Array to keep track of in-degrees (number of prerequisites for each course)
        int[] inDegree = new int[numCourses];

        // Fill the adjacency list and in-degree array
        for (int[] pair : prerequisites) {
            adjList.get(pair[1]).add(pair[0]);
            inDegree[pair[0]]++;
        }

        // Queue for courses with no prerequisites
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        // Process the courses
        int completedCourses = 0;
        while (!queue.isEmpty()) {
            int course = queue.poll();
            completedCourses++;

            // Reduce the in-degree of neighboring courses
            for (int neighbor : adjList.get(course)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If all courses are completed, there is no cycle
        return completedCourses == numCourses;
    }

    public static void main(String[] args) {
        int numCourses = 4;
        int[][] prerequisites = {{2, 0}, {3, 1}};
        System.out.println(canFinish(numCourses, prerequisites)); // Output: true

        int numCourses1 = 5;
        int[][] prerequisites1 = {{1, 0}, {2, 1}, {3, 2}, {4, 3}};
        System.out.println(canFinish(numCourses1, prerequisites1)); // Output: true

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}};
        System.out.println(canFinish(numCourses2, prerequisites2)); // Output: true

        int numCourses3 = 2;
        int[][] prerequisites3 = {{1, 0}, {0, 1}};
        System.out.println(canFinish(numCourses3, prerequisites3)); // Output: false
    }
}
