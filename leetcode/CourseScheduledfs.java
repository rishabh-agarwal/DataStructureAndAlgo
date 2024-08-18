package leetcode;

import java.util.*;

/**
 * Leetcode 207
 */
public class CourseScheduledfs {
    public static boolean canFinish(int numCourses, int[][] prerequisites) {
        HashMap<Integer, List<Integer>> preMap = new HashMap<>();
        Set<Integer> visiting = new HashSet<>();

        for(int i=0; i<numCourses; i++){
            preMap.put(i, new ArrayList<>());
        }

        for(int[] pair: prerequisites){
            preMap.get(pair[0]).add(pair[1]);
        }

        for(int c=0; c<numCourses; c++){
            if(!dfs(c, preMap, visiting)) return false;
        }
        return true;
    }

    private static boolean dfs(int crs, HashMap<Integer, List<Integer>> preMap, Set<Integer> visiting){
        if(visiting.contains(crs)) //if duplicate set is detected
            return false;

        if(preMap.get(crs).isEmpty()){
            return true;
        }

        visiting.add(crs);
        for(int pre: preMap.get(crs)){
            if(!dfs(pre, preMap, visiting)) return false;
        }
        visiting.remove(crs);
        preMap.put(crs, new ArrayList<>());
        return true;
    }

    public static void main(String[] args) {

        int numCourses1 = 5;
        int[][] prerequisites1 = {{1, 0}, {2, 1}, {3, 2}, {4, 3}};
        System.out.println(canFinish(numCourses1, prerequisites1)); // Output: true

        int numCourses = 4;
        int[][] prerequisites = {{2, 0}, {3, 1}};
        System.out.println(canFinish(numCourses, prerequisites)); // Output: true

        int numCourses2 = 2;
        int[][] prerequisites2 = {{1, 0}};
        System.out.println(canFinish(numCourses2, prerequisites2)); // Output: true

        int numCourses3 = 2;
        int[][] prerequisites3 = {{1, 0}, {0, 1}};
        System.out.println(canFinish(numCourses3, prerequisites3)); // Output: false
    }
}
