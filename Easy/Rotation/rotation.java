//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            int ans = new Solution().findKRotation(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    
    public static int binarySearch(int[] arr,int left,int right){
        int mid = (right+left) / 2;
        if(left <= right){
            if(left == right){
                return left;
            }
            if(arr[mid] <= arr[right]){
                return binarySearch(arr,left,mid);
            }
            else{
                return binarySearch(arr,mid + 1,right);
            }
        }
        return left;
    }
    
    int findKRotation(int arr[], int n) {
        // code here
        
        return binarySearch(arr,0,arr.length-1);
        
        //BRUTE FORCE
        // int count = 0;
        // for(int i =0;i<n-1;i++){
        //     if(arr[i+1] < arr[i]){
        //         count = i+1;
        //         break;
        //     }
        // }
        // return count;
    }
}