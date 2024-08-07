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

    private int tabulation(int[] arr, int n, int fee) {
        int[][] dp = new int[n + 1][2];
        int profit = 0;
        for (int[] r : dp)
            Arrays.fill(r, 0);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {

                if (j == 1) {
                    dp[i][j] = Math.max((-arr[i] + dp[i + 1][0]), dp[i + 1][1]);
                } else {
                    dp[i][j] = Math.max((-fee + arr[i] + dp[i + 1][1]), dp[i + 1][0]);
                }

            }

        }
        return dp[0][1];
    }

    private int tabulation2(int[] arr, int n, int fee) {
        int[] ahead = new int[2];
        int[] prev = new int[2];
        ahead[0] = ahead[1] = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
          
                    if (j == 1) {
                        prev[j] = Math.max((-arr[i] + ahead[0]), ahead[1]);
                    } else {
                        prev[j] = Math.max((-fee+arr[i] + ahead[1]), ahead[0]);
                    }
            }
            ahead[0] = prev[0];
            ahead[1] = prev[1];
                
            
        }
        return ahead[1];
    }

    public int maxProfit(int[] prices, int fee) {
        // dp = new int[prices.length][2];
        // for (int[] r : dp)
        // Arrays.fill(r, -1);
        return tabulation2(prices, prices.length, fee);

    }
}