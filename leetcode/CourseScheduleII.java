package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Leetcode: 207
 */
public class CourseScheduleII {

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] inDegree = new int[numCourses];

        for(int[] prereq: prerequisites){
            inDegree[prereq[0]]++;
        }

        List<Integer> order = new ArrayList<>();

        boolean courseFound;

        while(true){
            courseFound = false;
            for(int i=0; i<numCourses; i++){
                if(inDegree[i] ==0){
                    order.add(i);
                    inDegree[i] = -1;
                    courseFound = true;

                    for(int[] prereq: prerequisites){
                        if(prereq[1] == i){
                            inDegree[prereq[0]]--;
                        }
                    }
                }
            }
            if(!courseFound)
                break;
        }
        if (order.size() == numCourses) {
            return order.stream().mapToInt(i -> i).toArray();
        } else {
            return new int[0]; // Cycle detected, impossible to finish all courses
        }
    }

    public static void main(String[] args) {

        int numCourses1 = 5;
        int[][] prerequisites1 = {{1, 0}, {2, 1}, {3, 2}, {4, 3}};
        System.out.println(Arrays.toString(findOrder(numCourses1, prerequisites1))); // Output: true
    }
}


