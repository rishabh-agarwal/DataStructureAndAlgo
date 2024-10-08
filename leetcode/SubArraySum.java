package leetcode;

/**
 * Subarray sum equals K
 */
public class SubArraySum {
    public static int subarraySum(int[] nums, int k) {
        int c=0;
        for(int i=0; i<nums.length; i++)
        {
            int sum=0;
            for(int j=i; j<nums.length; j++)
            {
                sum+=nums[j];
                if(sum==k) c++;
            }
        }
        return c;
    }

    public static void main(String[] args) {
        subarraySum(new int[]{1,2,3}, 3);
    }
}
