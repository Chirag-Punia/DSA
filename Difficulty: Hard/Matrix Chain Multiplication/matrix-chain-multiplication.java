//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.matrixMultiplication(N, arr));
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    static int tmp(int[] arr,int i,int j,int[][] dp){
        if(i==j)return 0;
        if(dp[i][j] != -1)return dp[i][j];
        int mini = Integer.MAX_VALUE;
        for(int k = i;k<j;k++){
            int steps = (arr[i-1] * arr[k] * arr[j]) + tmp(arr,i,k,dp)
            + tmp(arr,k+1,j,dp);
            
            mini = Math.min(mini,steps);
        }
        return dp[i][j] = mini;
    }
    static int matrixMultiplication(int N, int arr[])
    {
        // code here
        int[][] dp = new int[N][N];
        for(int[] row : dp)Arrays.fill(row,-1);
        return tmp(arr,1,N-1,dp);
    }
}