//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            int K = sc.nextInt();
            int[] arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            int res = obj.minimizeCost(arr, N, K);
            System.out.println(res);
        }
    }
}
// } Driver Code Ends

class Solution {
    
    public int ans;
    public int dp[];
    public int tmp(int[] arr,int i,int k){
        if(i == 0){
            return 0;
        }
        if(dp[i] != 0)return dp[i];
        int min = Integer.MAX_VALUE;
        
        for(int j = 1;j<=k;j++){
            if(i-j >= 0){
                int jump = tmp(arr,i-j,k) +Math.abs(arr[i] - arr[i-j]);
                min = Math.min(jump,min);
            }   
            
        }
        dp[i] = min;
        return min;
    }
    public int minimizeCost(int arr[], int N, int K) {
        
        dp = new int[N];
        return tmp(arr,N-1,K);
        
        // int[] dp = new int[N];
        // dp[0] = 0; 

        // for (int i = 1; i < N; i++) {
        //     dp[i] = Integer.MAX_VALUE;
        //     for (int j = 1; j <= K; j++) {
        //         if (i - j >= 0) {
        //             dp[i] = Math.min(dp[i], dp[i - j] + Math.abs(arr[i] - arr[i - j]));
        //         }
        //     }
        // }

        // return dp[N - 1];
    }
}
