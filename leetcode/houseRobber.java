package leetcode;

public class houseRobber {
    public static int rob(int[] nums){
        if(nums.length==0) return 0;

        int dp[] = new int[nums.length+1];
        dp[0] = 0;
        dp[1] = nums[0];

        for(int i=1; i<nums.length; i++){
            dp[i+1] = Math.max(dp[i], dp[i-1]+nums[i]);
        }

        return dp[nums.length];
    }

    public static void main(String[] args) {
        System.out.println(rob(new int[]{1,2,3,1}));
    }
}


//[1,2,3,1]
//[0,1,2,3]

//dp[0] = 0; [0]
//dp[1] = nums[0]; [1]
//dp[2] = Math.max(dp[1], dp[1-1]+nums[1]) [
//dp[3] = Math.max(dp[1], dp[1-1]+nums[3])
