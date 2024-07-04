//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            long topDownans = obj.topDown(n);
            long bottomUpans = obj.bottomUp(n);
            if (topDownans != bottomUpans)
                System.out.println(-1);
            else
                System.out.println(topDownans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int MOD = 1000000007;
    static long fib(int n,long[] dp){
        if (n <= 1) return n;
        if (dp[n] != 0) return dp[n];
        dp[n] = (fib(n - 1, dp) + fib(n - 2, dp)) % MOD;
        return dp[n];
    }

    static long topDown(int n) {
        //USING RECURSION
        long[] dp = new long[n+1];
        return fib(n,dp);
    }

    static long bottomUp(int n) {
        // code here
        if (n == 0) return 0;
        if (n == 1) return 1;
        long prev2 = 0;
        long prev = 1;
        long curr = 1;
        for(int i = 2; i<= n;i++){
            curr = (prev + prev2) % MOD;
            prev2 = (prev) % MOD;
            prev = (curr) % MOD;
        }
        return (prev)%MOD;
    }
}
