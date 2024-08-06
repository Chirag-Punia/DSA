class Solution {
    int[][][] dp;

    int tmp(int[] arr, int buy, int i, int trans) {
        if (i >= arr.length || trans == 2) {
            return 0;
        }

        int profit = 0;
        if (dp[i][buy][trans] != -1)
            return dp[i][buy][trans];
        if (buy == 1) {

            profit = Math.max((-arr[i] + tmp(arr, 0, i + 1, trans)), tmp(arr, 1, i + 1, trans));

        } else {
            profit = Math.max((arr[i] + tmp(arr, 1, i + 1, trans + 1)), tmp(arr, 0, i + 1, trans));

        }

        return dp[i][buy][trans] = profit;
    }

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2][3];
        for (int[][] r : dp)
            for (int[] s : r)
                Arrays.fill(s, -1);
        return tmp(prices, 1, 0, 0);

    }
}