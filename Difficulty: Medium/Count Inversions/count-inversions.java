//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Sorting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long t = sc.nextLong();

        while (t-- > 0) {
            long n = sc.nextLong();
            long arr[] = new long[(int)n];

            for (long i = 0; i < n; i++) arr[(int)i] = sc.nextLong();

            System.out.println(new Solution().inversionCount(arr, (int)n));
        }
    }
}

// } Driver Code Ends




// User function Template for Java

class Solution {
    // arr[]: Input Array
    // N : Size of the Array arr[]
    // Function to count inversions in the array.
    static long inversionCount(long[] arr, int n) {
        // Your Code Here
        return mergeSort(arr, 0, n-1);
    }

    private static long mergeSort(long[] arr, int s, int e) {
        if (s >= e) return 0;
        int mid = (s+e)/2;
        long ans1 = mergeSort(arr, s, mid);
        long ans2 = mergeSort(arr, mid+1, e);
        return ans1 + ans2 + mergeArr(arr, s, e);
    }

    private static long mergeArr(long[] arr, int s, int e) {
        long total = 0;

        int mid = (s+e)/2;
        ArrayList<Long> list1 = new ArrayList<>();
        ArrayList<Long> list2 = new ArrayList<>();
        for (int i = s; i <= mid; i++) {
            list1.add(arr[i]);
        }
        for (int i = mid+1; i <= e; i++) {
            list2.add(arr[i]);
        }
        int i = s;
        int j = 0;
        int k = 0;
        while (j < list1.size() && k < list2.size()) {
            if (list1.get(j) <= list2.get(k)) {
                arr[i] = list1.get(j);
                j++;
            }
            else {
                total += list1.size()-j;
                arr[i] = list2.get(k);
                k++;
            }
            i++;
        }
        while (j < list1.size()) {
            arr[i] = list1.get(j);
            j++;
            i++;
        }
        while (k < list2.size()) {
            arr[i] = list2.get(k);
            k++;
            i++;
        }
        return total;
    }
}