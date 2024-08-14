package leetcode;

/**
 * Leetcode: 55
 */
public class JumpGame {
    public boolean canJump(int[] nums) {
        int n = nums.length-1;
        int goodIndex= n;

        for(int i=n-1; i>=0; i--){ //starts from second last index to starting
            if(i+nums[i] >= goodIndex)
                goodIndex = i;
        }

        if(goodIndex == 0)
            return true;
        else
            return false;
    }
}



//TEST CASES:

//2, 3, 1, 1, 4
//0, 1, 2, 3, 4

//3, 2, 1, 0, 4
//0, 1, 2, 3, 4

//3, 3, 3, 3, 4
//0, 1, 2, 3, 4