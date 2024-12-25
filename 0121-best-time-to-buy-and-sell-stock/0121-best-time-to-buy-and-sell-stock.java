class Solution {
    public int maxProfit(int[] prices) {
        int mini = Integer.MAX_VALUE,maxi = Integer.MIN_VALUE;
        for(int i = 0;i<prices.length;i++){
            mini = Math.min(mini,prices[i]);
            maxi = Math.max(maxi,prices[i] - mini);
        }
        return maxi;
    }
}