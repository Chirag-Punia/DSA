//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

public class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // consume the newline
        while (t-- > 0) {
            int k = sc.nextInt();
            sc.nextLine(); // consume the newline
            String input = sc.nextLine();
            String[] strNumbers = input.split(" ");
            int[] arr = new int[strNumbers.length];
            for (int i = 0; i < strNumbers.length; i++) {
                arr[i] = Integer.parseInt(strNumbers[i]);
            }
            Solution ob = new Solution();
            int res = ob.binarysearch(arr, k);
            System.out.println(res);
        }
        sc.close();
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    public int binarysearch(int[] arr, int k) {
        // Code Here
        int end = arr.length;
        return solve(arr,k,0,end-1);
    }
    public int solve(int[] a,int target, int start, int end){
        while(start <= end){
            int mid = (start + end) / 2;
            if(a[mid] == target){
                return mid;
            }
            else if(a[mid] > target){
                end = mid - 1;
            }
            else{
                start = mid + 1;
            }
        }
        return -1;
        
    }
}