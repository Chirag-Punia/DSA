class Solution {
    int[][] dp;
    int tmp(int[] arr,int buy,int i){
        if(i >= arr.length){
            return 0;
        }
        int profit = 0;
        if(dp[i][buy] != -1)return dp[i][buy];
        if(buy == 1){
            profit = Math.max((-arr[i] + tmp(arr,0,i+1)),tmp(arr,1,i+1));
        }
        else{
            profit = Math.max((arr[i] + tmp(arr,1,i+1)) , tmp(arr,0,i+1));
        }

        return dp[i][buy] = profit;
    }
    private int tabulation(int[] arr,int n){
        int[][] dp = new int[n+1][2];
        int profit = 0;
        dp[n][0] = dp[n][1] = 0;
        for(int i = n-1;i>=0;i--){
            for(int j = 1;j>=0;j--){
                if(j == 1){
                    dp[i][j] = Math.max((-arr[i] + dp[i+1][0]),dp[i+1][1]);
                }
                else{
                    dp[i][j] = Math.max((arr[i] + dp[i+1][1]),dp[i+1][0]);
                }
            }
            
        }
        return dp[0][1];
    }
    public int maxProfit(int[] arr) {
        
        // dp = new int[arr.length+1][2];
        // for(int[] r : dp)Arrays.fill(r,-1);
        return tabulation(arr,arr.length);
    }
}