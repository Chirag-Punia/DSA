//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long t = Integer.parseInt(br.readLine());
        for (int g = 0; g < t; g++) {
            String[] str = (br.readLine()).trim().split(" ");
            long arr[] = new long[str.length];
            for (int i = 0; i < str.length; i++) arr[i] = Integer.parseInt(str[i]);
            System.out.println(new Solution().inversionCount(arr));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long mergeSort(long arr[] , int i ,int j){
        if(i >= j)return 0;
        int mid = (i+j)/2;
        long ans1 = mergeSort(arr,i,mid);
        long ans2 = mergeSort(arr,mid + 1,j);
        return ans1 + ans2 + merge(arr,i,j,mid);
    }
    static long merge(long[] arr,int i,int j,int mid){
        List<Long> temp = new ArrayList<>();
        int total = 0;
        int left = i;
        int right = mid + 1;
        while(left <= mid && right <= j){
            if(arr[right] >= arr[left]){
                temp.add(arr[left]);
                left++;
            }
            else{
                temp.add(arr[right]);
                right++;
                total += (mid - left + 1);
            }
        }
         while (left <= mid) {
            temp.add(arr[left]);
            left++;
        }
        while (right <= j) {
            temp.add(arr[right]);
            right++;
        }
        for (int k = i; k <= j; k++) {
            arr[k] = temp.get(k - i);
        }
        return total;
    }
    static long inversionCount(long arr[]) {
        // Your Code Here
        return mergeSort(arr,0,arr.length - 1);
    }
}