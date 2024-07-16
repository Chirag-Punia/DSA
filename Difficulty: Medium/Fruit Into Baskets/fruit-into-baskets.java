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
        HashSet<Integer> set;
        int n = fruits.length;
        int ans = 0;
        for(int i = 0;i< n; i++){
            set = new HashSet<>();
            for(int j = i;j<n;j++){
                set.add(fruits[j]);
                if(set.size() > 2)break;
                ans = Math.max(ans,j - i + 1);
            }
        }
        return ans;
    }
}