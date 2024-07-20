class Solution {
    public int[][] dp;

    public int tmp(int i, int j, int n, int m) {
        if (i == m - 1 && j == n - 1)
            return 1;
        else if (i >= m || j >= n)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int l = tmp(i, j + 1, n, m);
        int r = tmp(i + 1, j, n, m);
        return dp[i][j] = l + r;
    }

    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                if(i == 0 && j == 0)dp[i][j] = 1;
                else{
                    int l = (j > 0) ? dp[i][j - 1] : 0;
                    int r = (i > 0) ? dp[i - 1][j] : 0;
                    dp[i][j] = l + r;
                }
            }
        }
        return dp[m-1][n-1];
    }
}