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
      int ans[] = obj.replaceWithRank(a,n);
      for(int e : ans)
      System.out.print(e+" ");
      System.out.println();
    }
  }
}

// } Driver Code Ends




//User function Template for Java

class Solution {
    static int[] replaceWithRank(int arr[], int N) {
     // code here
     int[] ans = new int[N];
     PriorityQueue<Integer> pq = new PriorityQueue<>();
     HashMap<Integer,Integer> mpp = new HashMap<>();
     for(int i = 0;i<N;i++){
         pq.add(arr[i]);
     }
     int rank = 1;
     //rank will only increase when we will find that element
    while (!pq.isEmpty()) {
        int element = pq.poll();
        if (!mpp.containsKey(element)) {
            mpp.put(element, rank++);
        }
    }
     for(int i = 0;i<N;i++){
         ans[i] = mpp.get(arr[i]);
     }
     return ans;
    
    
  }
}
     