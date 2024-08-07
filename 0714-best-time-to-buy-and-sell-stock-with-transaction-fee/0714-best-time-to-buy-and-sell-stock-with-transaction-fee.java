class Solution {
    int[][] dp;
    int tmp(int[] arr, int buy, int i, int fee) {
        if (i >= arr.length) {
            return 0;
        }

        int profit = 0;
        if (dp[i][buy] != -1)
            return dp[i][buy];
        if (buy == 1) {

            profit = Math.max((-arr[i] + tmp(arr, 0, i + 1, fee)), tmp(arr, 1, i + 1, fee));

        } else {
            profit = Math.max((-fee + arr[i] + tmp(arr, 1, i + 1, fee)), tmp(arr, 0, i + 1, fee));

        }

        return dp[i][buy] = profit;
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
                        dp[i][j][trans] = Math.max((arr[i] + dp[i + 1][1][trans + 1]), dp[i + 1][0][trans]);
                    }
                }
            }

        }
        return dp[0][1][0];
    }

    private int tabulation2(int[] arr, int n, int k) {
        int[][] ahead = new int[2][k + 1];
        int[][] prev = new int[2][k + 1];
        for (int i = 0; i < 2; i++) {
            Arrays.fill(ahead[i], 0);
        }
        int profit = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                for (int trans = 0; trans < k; trans++) {

                    if (j == 1) {
                        prev[j][trans] = Math.max((-arr[i] + ahead[0][trans]), ahead[1][trans]);
                    } else {
                        prev[j][trans] = Math.max((arr[i] + ahead[1][trans + 1]), ahead[0][trans]);
                    }
                }

            }
            for (int j = 0; j <= 1; j++) {
                for (int trans = 0; trans < k; trans++) {
                    ahead[j][trans] = prev[j][trans];
                }
            }
        }
        return ahead[1][0];
    }

    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][2];
        for (int[] r : dp)
            Arrays.fill(r, -1);
        return tmp(prices, 1, 0, fee);

    }
}