class Solution {
    int[][] dp;
    int ans;

    int tmp(int[] nums, int i, int prev) {
        int newPrev = prev + 1;
        if (i >= nums.length)
            return 0;
        if (dp[i][newPrev] != -1)
            return dp[i][newPrev];
        int include = 0;
        if (prev == -1 || nums[i] > nums[prev])
            include = 1 + tmp(nums, i + 1, i);
        int exclude = tmp(nums, i + 1, prev);
        return dp[i][newPrev] = Math.max(include, exclude);
    }

    int tabulation(int[] nums) {
        int n = nums.length;
        int[][] memo = new int[n+1][n+1];
        for (int[] r : memo)
            Arrays.fill(r, 0);
        for(int i = n-1;i>=0;i--){
            for(int prev = i - 1;prev >= -1;prev--){
                memo[i][prev + 1] = memo[i+1][prev+1];
                if(prev == -1 || nums[i] > nums[prev]){
                    memo[i][prev+1] = Math.max(1 + memo[i+1][i+1],memo[i][prev+1]);
                }
            }
        }
        return memo[0][0];
    }

    public int lengthOfLIS(int[] nums) {
        dp = new int[nums.length][nums.length];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        return tabulation(nums);
    }
}