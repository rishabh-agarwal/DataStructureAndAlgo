package leetcode;

import java.util.Arrays;

public class RotateArrayKtimes {

    public static void rotate(int[] nums, int k) {
        int length = nums.length;
        int[] res = Arrays.copyOf(nums, length);
        for(int i=0; i<length; i++){
            if(i+k>length-1){
                nums[(i+k)%length] = res[i];
            }else {
                nums[i+k]= res[i];
            }
        }
        System.out.println(Arrays.toString(nums));
    }

    public static void main(String[] args) {
        rotate(new int[]{1,2,3,4,5,6,7}, 3);
    }
}
