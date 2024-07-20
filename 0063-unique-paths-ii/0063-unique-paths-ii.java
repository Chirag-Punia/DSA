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
        if(obstacleGrid[obstacleGrid.length -1][obstacleGrid[0].length - 1] == 1)return 0;
        dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return tmp(0, 0, obstacleGrid);
    }
}