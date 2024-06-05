//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main(String[] args) throws IOException
	{
	        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t =
            Integer.parseInt(br.readLine().trim()); // Inputting the testcases
        while(t-->0)
        {
            long n = Long.parseLong(br.readLine().trim());
            long a[] = new long[(int)(n)];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Long.parseLong(inputLine[i]);
            }
            
            Solution obj = new Solution();
            System.out.println(obj.pairWithMaxSum(a, n));
            
        }
	}
}


// } Driver Code Ends


//User function Template for Java

class Solution {
    
    public static long pairWithMaxSum(long arr[], long N)
    {
        // Your code goes here
       long ans = 0;
       for(int i = 0 ; i<N-1;i++){
           if(arr[i] + arr[i+1] > ans){
               ans = arr[i] + arr[i+1];
           }
           
       }
       return ans;
    }
}