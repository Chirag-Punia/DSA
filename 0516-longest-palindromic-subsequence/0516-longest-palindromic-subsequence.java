class Solution {
    
    private int helper(String s, int l, int r, int [][] dp){
        if(l==r)
            return 1;
        
        if(l>r)
            return 0;
        
        if(dp[l][r]!=-1)
            return dp[l][r];
        
        if(s.charAt(l) == s.charAt(r)){
            dp[l][r] = 2 + helper(s, l+1, r-1, dp);
        }
        else{
            int lIncrement = helper(s,l+1,r, dp);
            int rIncrement =  helper(s,l,r-1, dp);                          
            dp[l][r] = Math.max(lIncrement, rIncrement);
        }
        
        return dp[l][r];
        
        
    }    
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        if(n==0 || s==null)
            return 0;
        int [][] dp = new int[n][n];
        for (int[] row : dp) 
            Arrays.fill(row, -1);
        return helper(s, 0, s.length()-1,dp);
    }
}