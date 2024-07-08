//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.maxSumBitonicSubArr(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public long maxSum(long[] arr, int l, int r){
        long sum = 0;
        for(int i=l; i<r; i++)
        sum += arr[i];
        return sum;
    }
    
    public long maxSumBitonicSubArr(long arr[], long n)
    {
        int i=0;
        long maxSum = 0;
        while(i<n){
            int j = i;
            while(j<n-1 && arr[j] < arr[j+1]){
                j++;
            }
            
            while(i<j && arr[i] <= 0){
                i++;
            }
            int k = j;
            while(k<n-1 && arr[k] > arr[k+1]){
                k++;
            }
            int last = k;
            while(k>j && arr[k] <= 0){
                k--;
            }
            long leftSum = maxSum(arr, i, j+1);
            long rightSum = maxSum(arr, j, k+1);
            long sum = leftSum + rightSum - arr[j];
            maxSum = Math.max(Math.max(maxSum, leftSum), Math.max(sum, rightSum));
            i = Math.max(last, i+1);
            
        }
        return maxSum;
    }
}