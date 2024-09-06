class Solution {
    int[][] dp;
    int tmp(String w1,String w2,int i,int j){
        if(i < 0)return j+1;
        if(j < 0)return i+1;
        if(dp[i][j] != -1)return dp[i][j];
        if(w1.charAt(i) == w2.charAt(j))return tmp(w1,w2,i-1,j-1);
        int insert = 1 + tmp(w1,w2,i,j-1);
        int delete = 1 + tmp(w1,w2,i-1,j);
        int replace = 1 + tmp(w1,w2,i-1,j-1);
        return dp[i][j] = Math.min(insert,Math.min(delete,replace));
    }
    public int minDistance(String word1, String word2) {
        dp = new int[word1.length()][word2.length()];
        for(int[] row : dp)
            Arrays.fill(row,-1);
        return tmp(word1,word2,word1.length()-1,word2.length()-1);
    }
}