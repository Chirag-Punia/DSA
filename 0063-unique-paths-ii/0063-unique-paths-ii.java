class Solution {
    public int[][] dp;

    public int tmp(int i, int j, int[][] o) {
        if (i == o.length - 1 && j == o[0].length - 1)
             return 1;
        else if (i >= o.length || j >= o[0].length || o[i][j] == 1)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int l = tmp(i, j + 1,o);
        int r = tmp(i + 1, j,o);
        return dp[i][j] = l + r;
    }
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;
        if(obstacleGrid[n-1][m- 1] == 1 || obstacleGrid[0][0] == 1)return 0;
        dp = new int[n][m];
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                int l = 0,r = 0;
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                    continue;
                }
                if(obstacleGrid[i][j]  == 1){
                    dp[i][j] = 0;
                    continue;
                }
                else{
                    if(j > 0)l = dp[i][j-1];
                    if(i > 0)r = dp[i-1][j];
                    dp[i][j] = l + r;
                }
                
            }
        }
        return dp[n-1][m-1];
    }
}