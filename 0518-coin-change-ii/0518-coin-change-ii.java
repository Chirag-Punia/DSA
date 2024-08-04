class Solution {
    int cnt;
    int[][] dp;
    public int tmp(int[] coins, int target, int i) {
        if (target == 0) {
            return 1;
        }
        if (i >= coins.length)
            return 0;
        if(dp[i][target] != -1)return dp[i][target];
        int rep = 0;
        if(coins[i] <= target){
            rep = tmp(coins, target - coins[i], i);
        }
        
        int nonRep = tmp(coins, target, i + 1);
        return dp[i][target] = rep+nonRep;
    }

    public int change(int amount, int[] coins) {
        cnt = 0;
        dp = new int[coins.length + 1][amount + 1];
        for(int[] row : dp)Arrays.fill(row,-1);
        return tmp(coins, amount, 0);
    }
}