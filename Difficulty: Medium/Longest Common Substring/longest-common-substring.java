//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S1 = read.readLine().trim();
            String S2 = read.readLine().trim();

            Solution ob = new Solution();
            System.out.println(ob.longestCommonSubstr(S1, S2));
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    int[][] dp;
    public int tmp(String s1, String s2, int i, int j) {
        if (i >= s1.length() || j >= s2.length()) {
            return 0;
        }
        if(dp[i][j] != -1)return dp[i][j];
        int currentCount = 0;
        
        if (s1.charAt(i) == s2.charAt(j)) {
            currentCount = 1 + tmp(s1, s2, i + 1, j + 1);
        }

        tmp(s1, s2, i + 1, j);
        tmp(s1, s2, i, j + 1);

        return dp[i][j] = currentCount;
    }
    public int longestCommonSubstr(String s1, String s2) {
        // code here
        int n = s1.length();
        int m  = s2.length();
        dp = new int[n][m];
        for(int[] r : dp)Arrays.fill(r,-1);
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                maxLength = Math.max(maxLength, tmp(s1, s2, i, j)); 
            }
        }
        return maxLength;
    }
}