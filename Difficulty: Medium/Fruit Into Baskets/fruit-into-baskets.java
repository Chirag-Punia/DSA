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

            int N;
            N = sc.nextInt();

            int[] fruits = new int[N];
            for (int i = 0; i < N; i++) fruits[i] = sc.nextInt();

            Solution obj = new Solution();
            int res = obj.totalFruits(N, fruits);

            System.out.println(res);
        }
    }
}
// } Driver Code Ends

// User function Template for Java

class Solution {
    public static int totalFruits(int N, int[] fruits) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int n = fruits.length;
        int ans = 0;
        int left = 0;
        int right = 0;
        while(right < n){
            mpp.put(fruits[right],mpp.getOrDefault(fruits[right],0)+1);
            while(mpp.size() > 2){
                int curr = fruits[left];
                mpp.put(curr,mpp.get(curr) - 1);
                if(mpp.get(curr) == 0)mpp.remove(curr);
                left++;
            }
            ans = Math.max(ans,right - left + 1);
            right++;

        }
        return ans;
        // for(int i = 0;i< n; i++){
        //     set = new HashSet<>();
        //     for(int j = i;j<n;j++){
        //         set.add(fruits[j]);
        //         if(set.size() > 2)break;
        //         ans = Math.max(ans,j - i + 1);
        //     }
        // }
        // return ans;
    }
}