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

    private int tabulation(int[] arr, int n) {
        int[][][] dp = new int[n + 1][2][3];
        int profit = 0;
        for (int i = 0; i < 3; i++) {
            dp[n][0][i] = 0;
            dp[n][1][i] = 0;
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                for (int trans = 0; trans < 2; trans++) {

                    if (j == 1) {
                        dp[i][j][trans] = Math.max((-arr[i] + dp[i + 1][0][trans]), dp[i + 1][1][trans]);
                    } else {
                        dp[i][j][trans] = Math.max((arr[i] + dp[i + 1][1][trans+1]), dp[i + 1][0][trans]);
                    }
                }
            }

        }
        return dp[0][1][0];
    }

    public int maxProfit(int[] prices) {
        // dp = new int[prices.length][2][3];
        // for (int[][] r : dp)
        //     for (int[] s : r)
        //         Arrays.fill(s, -1);
        return tabulation(prices,prices.length);

    }
}