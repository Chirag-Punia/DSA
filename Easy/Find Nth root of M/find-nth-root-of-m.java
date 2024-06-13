//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String s = br.readLine().trim();
            String[] S1 = s.split(" ");
            int n = Integer.parseInt(S1[0]);
            int m = Integer.parseInt(S1[1]);
            Solution ob = new Solution();
            int ans = ob.NthRoot(n, m);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution
{
    
    public static int binarySearch(int n,int m,int left,int right){
        int mid = (left+right)/2;
        int val = (int)Math.pow(mid,n);
        if(left <= right){
            
            if(val == m){
            return mid;
            }
            else if(val > m){
                return binarySearch(n,m,left,mid-1);
            }
            else{
                return binarySearch(n,m,mid+1,right);
            }
            
        }
        
        return -1;
        
    }
    public int NthRoot(int n, int m)
    {
        
        return binarySearch(n,m,0,m);
        
        //BRUTE FORCE
        // int ans = -1;
        // for(int i = 0;i<=m;i++){
        //     int val = (int)Math.pow(i,n);
        //     if(val == m){
        //         ans = i;
        //         break;
        //     }
            
            
        // }
        // return ans;
    }
}