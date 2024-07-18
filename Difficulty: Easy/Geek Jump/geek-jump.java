//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int []arr=new int[N];
            for(int i=0;i<N;i++){
                arr[i]=sc.nextInt();
                
            }
            Solution obj=new Solution();
            int res=obj.minimumEnergy(arr,N);
            System.out.println(res);
            
        }
    }
}


// } Driver Code Ends


//User function Template for Java


class Solution{
    public int ans;
    public int dp[];
    int tmp(int[] arr,int i){
        if(i == 0){
            return 0;
        }
        if(dp[i] != 0)return dp[i];
        int oneStep = tmp(arr,i-1) + Math.abs(arr[i] - arr[i-1]);
        int twoStep = (i>1)?tmp(arr,i-2) + Math.abs(arr[i] - arr[i-2]):Integer.MAX_VALUE;
        int min = Math.min(oneStep,twoStep);
        dp[i] = min;
        return min;
    }
    public int minimumEnergy(int arr[],int N){
        //code here
        ans = Integer.MAX_VALUE;
        dp = new int[N];
        return tmp(arr,N-1);
    }
}