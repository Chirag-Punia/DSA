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
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    
// } Driver Code Ends


//User function Template for Java

class Solution
{
    int[][] dp;
    public int tmp(int arr[] ,int i,int prev){
        int prevIndex = prev + 1;
        if(i >= arr.length){
            return 0;
        }
        if(dp[i][prevIndex] != -1)return dp[i][prevIndex];
        int include = 0,exclude = tmp(arr,i+1,prev);
        if(prev == -1 || arr[prev] < arr[i])
            include = arr[i] + tmp(arr,i+1,i);
            
        return dp[i][prevIndex] = Math.max(include,exclude);
    }
	public int maxSumIS(int arr[], int n)  
	{  
	    //code here.
	    dp = new int[n+1][n+1];
	    for(int[] row : dp)
	        Arrays.fill(row,-1);
	    return tmp(arr,0,-1);
	}  
}