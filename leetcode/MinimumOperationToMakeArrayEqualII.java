package leetcode;

public class MinimumOperationToMakeArrayEqualII {
    public static long minOperations(int[] nums1, int[] nums2, int k) {
        long add = 0;
        long sub = 0;
        for(int i = 0; i < nums1.length; i++){
            int diff = nums1[i] - nums2[i];
            if(k != 0){
                if(diff % k != 0){
                    return -1;
                }
                if(diff > 0){
                    add = add + diff/k;

                }else if(diff < 0){
                    sub = sub + (-diff)/k;
                }
            }else{
                if(diff != 0){
                    return -1;
                }
            }

        }
        return add == sub ? add : -1;
    }

    public static void main(String[] args) {
        //System.out.println(minOperations(new int[]{4,3,1,4}, new int[]{1,3,7,1}, 3));
        System.out.println(minOperations(new int[]{4,3,1,4}, new int[]{1,3,7,1}, 3));
    }
}
