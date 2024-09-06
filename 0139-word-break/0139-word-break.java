class Solution {
    public boolean tmp(String s,int idx,Set<String> set,int n,Boolean[] dp){
        if(idx >= n)return true;
        if(dp[idx] != null)return dp[idx];
        for(int k = idx;k <= s.length();k++){
            String temp = s.substring(idx,k);
            if(set.contains(temp) && tmp(s,k,set,n,dp)){
                dp[idx] = true;
                return true;
            }
        }
        dp[idx] = false;
        return false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        HashSet<String> set = new HashSet<>();
        Boolean[] dp = new Boolean[s.length()];
        for(String t : wordDict)
            set.add(t);
        return tmp(s,0,set,s.length(),dp);
    }
}