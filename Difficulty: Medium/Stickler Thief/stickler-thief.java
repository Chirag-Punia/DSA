//{ Driver Code Starts
import java.util.*;
import java.io.*;

class GFG
 {
	public static void main (String[] args)
	 {
	  
	  //taking input using Scanner class
	  Scanner sc = new Scanner(System.in);
	  
	  //taking count of testcases
	  int t = sc.nextInt();
	  while(t-- > 0){
	      
	      //taking count of houses
	      int n = sc.nextInt();
	      int arr[] = new int[n];
	      
	      //inserting money present in 
	      //each house in the array
	      for(int i = 0; i<n; ++i)
	           arr[i] = sc.nextInt();
  	      
  	      //calling method FindMaxSum() of class solve
  	      System.out.println(new Solution().FindMaxSum(arr, n));
	 }
   }
}
// } Driver Code Ends



class Solution
{
    //Function to find the maximum money the thief can get.
    int[] dp;
    public int FindMaxSum(int arr[], int n)
    {
        // Using O(1) space
        
        if (n == 0) return 0;
        if (n == 1) return arr[0];
        
        int prev = arr[0]; // i -1
        int prev2 = 0;        // i -2
        
        for (int i = 1; i < n ; i++) {
            int current = Math.max(prev, prev2 + arr[i]);
            prev2 = prev;
            prev = current;
        }
        
        return prev;
        
        // //iterative
        // if(n == 0) return 0;
        // if (n == 1) return 1;
        // dp = new int[n];
        // dp[0] = arr[0];
        // dp[1] = Math.max(dp[0], arr[1]);
        
        // for (int i = 2; i < n; i++) {
        //     dp[i] = Math.max(dp[i - 1], dp[i -2] + arr[i]);
        // }
        
        // return dp[n - 1];
        
        
    //     dp = new int[n];
    //     Arrays.fill(dp, -1);
        
    //     return FindMax (arr, n - 1);
    // }
    
    // public int FindMax(int arr[], int n) {
    //     if (n < 0) return 0;
    //     if(dp[n] != -1) return dp[n];
        
    //     int include = FindMax(arr, n - 2) + arr[n];
    //     int exclude = FindMax(arr, n - 1);
    //     dp[n] =  Math.max(include, exclude);
    //     return Math.max(include, exclude);

    }
}