class Solution {
    int[][] dp;
    int ans;
    int tmp(int[] nums,int i,int prev){
        int newPrev = prev + 1;
        if(i >= nums.length)
            return 0;
        if(dp[i][newPrev] != -1)return dp[i][newPrev];
        int include = 0;
        if(prev == -1 || nums[i] > nums[prev])
            include =  1 + tmp(nums,i+1,i);
        int exclude = tmp(nums,i+1,prev);
        return dp[i][newPrev] = Math.max(include , exclude);
    }
    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return tmp(nums,0,-1);
    }
}