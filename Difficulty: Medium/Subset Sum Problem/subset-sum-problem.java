//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int arr[]= new int[N];
            for(int i = 0; i < N; i++)
                arr[i] = Integer.parseInt(input_line[i]);
            int sum = Integer.parseInt(read.readLine());

            Solution ob = new Solution();
            if(ob.isSubsetSum(N, arr, sum))
            System.out.println(1);
            else
            System.out.println(0);

            
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static int[][] dp;
    public static int s;
     static boolean tmp(int arr[], int i, int sum) {
        if(s == sum) return true;
        if(i >= arr.length || s > sum) return false;
        if(dp[i][s] != -1)return dp[i][s] == 1;
        s+=arr[i];
        boolean include = tmp(arr,i+1,sum);
        s-=arr[i];
        boolean exclude = tmp(arr,i+1,sum);
        dp[i][s] = (include || exclude)?1:0;
        return dp[i][s] == 1;
    }
    
    static Boolean isSubsetSum(int N, int arr[], int sum){
        // code here
        dp = new int[N][sum+1];
        s = 0;
        for(int i = 0;i<N;i++){
            Arrays.fill(dp[i],-1);
        }
        
        return tmp(arr,0,sum);
    }
}