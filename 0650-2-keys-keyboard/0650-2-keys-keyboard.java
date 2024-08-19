class Solution {
    int[][] dp;
    int tmp(int count,int paste,int n){
        if(count == n)return 0;
        if(count > n)return 10000;
        
        if(dp[count][paste] != -1)return dp[count][paste];
        int pastee = 1 + tmp(count + paste,paste,n);
        int copyAndPaste = 2 + tmp(count + count,count,n);

        return dp[count][paste] = Math.min(pastee,copyAndPaste);
    }
    public int minSteps(int n) {
        dp = new int[n+1][n+1];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        if(n == 1)return 0;
        return 1+ tmp(1,1,n);
    }
}