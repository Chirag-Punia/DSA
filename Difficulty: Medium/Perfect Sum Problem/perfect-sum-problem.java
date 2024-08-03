//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    int sum = sc.nextInt();
                    int arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                    arr[i] = sc.nextInt();
                    
                    Solution ob = new Solution();
                    System.out.println(ob.perfectSum(arr,n,sum));
                }
        }
}    
// } Driver Code Ends





class Solution{
    public static int[][] dp;
    public int tmp(int[] arr,int sum, int i,int target){
        if(i == 0){
            if(target == 0 && arr[0] == 0) return 2;
	        if(target == 0) return 1;
	        if(arr[0] == target) return 1;
	        return 0;
        }
        if(dp[i][target] != -1)return dp[i][target];
        int include = 0;
        if(arr[i]<=target)
            include = tmp(arr,sum,i-1,target-arr[i]);
        int exclude = tmp(arr,sum,i-1,target);
        return dp[i][target] = (include + exclude)%((int)(1e9+7)) ;
    }
	public int perfectSum(int arr[],int n, int sum) 
	{ 
	    // Your code goes here
	    dp = new int[n][sum+1];
	    for(int row[] : dp)Arrays.fill(row,-1);
	    return tmp(arr,sum,n-1,sum);
	    
	} 
}