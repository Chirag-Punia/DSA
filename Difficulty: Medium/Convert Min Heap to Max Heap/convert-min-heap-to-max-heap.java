//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      int a[] = new int[n];
      for(int i=0;i<n;i++){
        a[i]=sc.nextInt();
      }
      Solution obj = new Solution();
      obj.convertMinToMaxHeap(n,a);
      for(int e : a)
      {
          System.out.print(e+" ");
      }
      System.out.println();
    }
  }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    public static void MaxHeapify(int i,int heap_size , int harr[]) {
        int l = 2 * i + 1;
        int r = 2 * i + 2;
        int smallest = i;
        if (l < heap_size && harr[l] > harr[i]) smallest = l;
        if (r < heap_size && harr[r] > harr[smallest]) smallest = r;
        if (smallest != i) {
            int temp = harr[i];
            harr[i] = harr[smallest];
            harr[smallest] = temp;
            MaxHeapify(smallest,heap_size,harr);
        }
    }
    public static void heapSort(int N,int arr[]){
        for(int i = N/2;i>=0;i--){
            MaxHeapify(i,N,arr);
        }
    }
    static void convertMinToMaxHeap(int N, int arr[]) {
    // code here
    heapSort(N,arr);

  }
}
     