class Solution {
    public int coin(int[] coins , int amount , int ind , int[][] dp){
        if(ind == 0)
        {
            if(amount%coins[0] == 0)
                return amount/coins[0];
            else
                return Integer.MAX_VALUE-10000;
        }
        if(amount == 0)
            return 0;
        if(dp[ind][amount] != -1)
            return dp[ind][amount];
        
        
        int notTake = coin(coins , amount , ind-1 , dp);
        int take = Integer.MAX_VALUE;
        if(amount >= coins[ind])
            take = 1 + coin(coins , amount-coins[ind] , ind , dp);
        
        return dp[ind][amount] = Math.min(take , notTake);
    }
        public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount+1];
        for(int i = 0 ; i < n ; i ++)
            for(int j = 0 ; j <= amount ; j++)
                dp[i][j] = -1;
        
        int ret = Math.max(-1 , coin(coins , amount , n-1 , dp));
        if(ret >= 1000000)
            return -1;
        return ret;
    }
}