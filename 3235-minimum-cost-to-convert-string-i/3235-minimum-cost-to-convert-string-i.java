class Solution {
    public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
        long dp[][]=new long[26][26];
        for(int i=0;i<26;i++){
            Arrays.fill(dp[i],Integer.MAX_VALUE);
            dp[i][i]=0;
        }
        for(int i=0;i<original.length;i++){
            int x=original[i]-'a';
            int y=changed[i]-'a';
            dp[x][y]=Math.min(dp[x][y],cost[i]);
        }
        for(int k=0;k<26;k++){
            for(int i=0;i<26;i++){
            for(int j=0;j<26;j++){
                dp[i][j]=Math.min(dp[i][k]+dp[k][j],dp[i][j]);
            }
        }
        }
        long ans=0;
        for(int i=0;i<source.length();i++){
            int x=source.charAt(i)-'a';
            int y=target.charAt(i)-'a';
            if(x==y)continue;
            else if(dp[x][y]==Integer.MAX_VALUE)return -1;
            else{
                ans+=dp[x][y];
            }
        }
        return ans;
    }
}