class Solution {
    public int[][] dp;
    public int tmp(int i,int j,int n,int m){
        if(i == m-1 && j == n-1){
            return 1;
        }
        if(i >= m || j >= n)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int l = tmp(i,j+1,n,m);
        int r = tmp(i+1,j,n,m);
        dp[i][j] = l+r;
        return dp[i][j];
    }
    public int uniquePaths(int m, int n) {
        dp = new int[m][n];
        for(int i = 0;i<m;i++){
            Arrays.fill(dp[i],-1);
        }
        return tmp(0,0,n,m);

    }
}