package leetcode;

/**
 *Leetcode: 26
 */

public class RemoveDuplicateFromSortedArray {

    public int removeDuplicates(int[] nums) {
        int k=1;
        for (int i=1; i<nums.length; i++){
            if(nums[i-1]!=nums[i]){
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }
}

//1,1,2