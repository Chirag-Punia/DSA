//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        while (t-- > 0) {

            int n;
            n = sc.nextInt();

            int k;
            k = sc.nextInt();

            int[] v = new int[n];
            for (int i = 0; i < n; i++) v[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.solve(n, k, v);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends


// User function Template for Java
class Solution {
    static boolean isPossible(int[] stalls,int threshold,int k){
        int prev = stalls[0];
        k--;
        for(int i = 1;i<stalls.length;i++){
            if(stalls[i] - prev >= threshold){
                prev = stalls[i];
                k--;
            }
            if(k == 0)return true;
            
        }
        return false;
    }
    public static int solve(int n, int k, int[] stalls) {
        int ans = Integer.MIN_VALUE;
        Arrays.sort(stalls);
        int maxi = stalls[n-1] - stalls[0];
        int low = 1;
        int high = maxi;
        while(low <= high){
            int mid = (low + high)/2;
            if(isPossible(stalls,mid,k)){
                ans = mid;
                low = mid+1;
            }
            else{
                high = mid - 1;
            }
        }
        return ans;
    }
}