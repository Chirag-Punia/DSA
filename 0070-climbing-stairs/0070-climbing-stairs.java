class Solution {
    public int[] dp;
    public int helper(int n){
        if(n <= 1) return 1;
        if(dp[n] != 0) return dp[n];
        return dp[n]=helper(n-1) + helper(n-2);
     }
    public int climbStairs(int n) {
        dp = new int[n+1];
        return helper(n);
    }
}