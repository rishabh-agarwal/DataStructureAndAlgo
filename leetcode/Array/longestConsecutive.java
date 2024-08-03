package leetcode.Array;

import java.util.Arrays;

public class longestConsecutive {

    public static int longestConsecutive(int[] nums) {
        if(nums.length==0) return 0;
        int current=1;
        int max = 0;
        Arrays.sort(nums);

        for(int i=0; i<nums.length-1; i++){
            if(nums[i+1]-nums[i]==1)
                current+=1;
            else if (nums[i+1]-nums[i]!=1) {
                max = Math.max(max, current);
                current = 1;
            }
        }
        return Math.max(current, max);
    }

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{1,2,0,1}));
    }
}
//0,1,1,2
//1,2,3,4,100,200
//0,1,2,3,4,5,6,7,8,0
//-1, -1, 0, 1, 3, 4, 5, 6, 7, 8, 9