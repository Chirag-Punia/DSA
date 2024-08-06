class Solution {
    int profit;
    int[][] dp;
    int tmp(int[] arr,int buy,int i){
        if(i >= arr.length){
            return 0;
        }
        if(dp[i][buy] != -1)return dp[i][buy];
        if(buy == 1){
            profit = Math.max((-arr[i] + tmp(arr,0,i+1)),tmp(arr,1,i+1));
        }
        else{
            profit = Math.max((arr[i] + tmp(arr,1,i+1)) , tmp(arr,0,i+1));
        }

        return dp[i][buy] = profit;
    }

    public int maxProfit(int[] arr) {
        
        dp = new int[arr.length+1][2];
        for(int[] r : dp)Arrays.fill(r,-1);
        profit = Integer.MIN_VALUE;
        return tmp(arr,1,0);
    }
}