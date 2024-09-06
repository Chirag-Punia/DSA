//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static boolean isPalindrome(String str){
        int l = 0;
        int r = str.length() - 1;
        while(l < r){
            if(str.charAt(l) != str.charAt(r)){
              return false; 
            }
            l++;
            r--; 
        }
        return true;
    }
    static int tmp(String str,int i,int[] dp){
        if(i >= str.length())return 0;
        if(dp[i] != -1)return dp[i];
        String x = "";
        int mini = Integer.MAX_VALUE;
        for(int j = i;j<str.length();j++){
            x = x + str.charAt(j);
            if(isPalindrome(x)){
                int ans = 1 +tmp(str,j+1,dp);
                mini = Math.min(mini,ans);
            }
        }
        return dp[i] = mini;
    }
    static int palindromicPartition(String str)
    {
        // code here
        int[] dp = new int[str.length()];
        Arrays.fill(dp,-1);
        return tmp(str,0,dp) - 1;
    }
}