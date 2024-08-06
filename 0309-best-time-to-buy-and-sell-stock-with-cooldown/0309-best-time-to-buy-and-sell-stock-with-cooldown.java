class Solution {
    int[][][] dp;
    int tmp(int[] arr, int buy, int i, int cool) {
        if (i >= arr.length) {
            return 0;
        }

        int profit = 0;
        if (dp[i][buy][cool] != -1)
            return dp[i][buy][cool];
         if (buy == 1 && cool == 0) {
            profit = Math.max(-arr[i] + tmp(arr, 0, i + 1, 0), tmp(arr, 1, i + 1, 0));
        } else if (buy == 0) {
            profit = Math.max(arr[i] + tmp(arr, 1, i + 1, 1), tmp(arr, 0, i + 1, 0));
        } else if (cool == 1) {
            profit = tmp(arr, 1, i + 1, 0);
        }

        return dp[i][buy][cool] = profit;
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
    private int tabulation2(int[] arr, int n) {
        int[][] ahead = new int[2][3];
        int[][] prev = new int[2][3];
        for(int i = 0;i<2;i++){
            Arrays.fill(ahead[i],0);
        }
        int profit = 0;
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 1; j >= 0; j--) {
                for (int trans = 0; trans < 2; trans++) {

                    if (j == 1) {
                        prev[j][trans] = Math.max((-arr[i] + ahead[0][trans]), ahead[1][trans]);
                    } else {
                        prev[j][trans] = Math.max((arr[i] + ahead[1][trans+1]), ahead[0][trans]);
                    }
                }
                
            }
            for (int j = 0; j <= 1; j++) {
            for (int trans = 0; trans < 3; trans++) {
                ahead[j][trans] = prev[j][trans];
            }
        }
        }
        return ahead[1][0];
    }

    public int maxProfit(int[] prices) {
        dp = new int[prices.length][2][2];
        for (int[][] r : dp)
            for (int[] s : r)
                Arrays.fill(s, -1);
        return tmp(prices,1,0,0);

    }
}