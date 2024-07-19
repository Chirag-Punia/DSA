class Solution {
    public int[] dp;
    public int tmp(int[] nums, int i){
        if(i == 0)return nums[0];
        if(i < 0) return 0;
        if(dp[i] != -1)return dp[i];
        int pick = nums[i] + tmp(nums,i-2);
        int notPick = tmp(nums,i-1);
        dp[i] = Math.max(pick,notPick);
        return dp[i];
    }
    public int rob(int[] nums) {
        dp = new int[nums.length];
        for(int i = 0;i<nums.length;i++){
            dp[i] = -1;
        }
       return tmp(nums,nums.length-1);
    }
}