class Solution {
    public int ans;
    public int[][] dp;
    public int tmp(int[][] g, int i, int j) {
        if (i == g.length - 1 && j == g[0].length - 1){
            return g[i][j];
        }
        if (i >= g.length || j >= g[0].length)
            return Integer.MAX_VALUE;
        if (dp[i][j] != -1) return dp[i][j];
        int l = tmp(g, i, j + 1);
        int r = tmp(g, i + 1, j);
        dp[i][j] = g[i][j] + Math.min(l, r);
        return dp[i][j];
    }

    public int minPathSum(int[][] grid) {
        ans = Integer.MAX_VALUE;
        dp = new int[grid.length][grid[0].length];
        for(int i = 0 ;i<grid.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return tmp(grid, 0, 0);

    }
}