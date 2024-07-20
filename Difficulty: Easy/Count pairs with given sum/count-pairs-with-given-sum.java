//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            int k = Integer.parseInt(read.readLine().trim());
            String line = read.readLine().trim();
            String[] numsStr = line.split(" ");
            int[] nums = new int[numsStr.length];
            for (int i = 0; i < numsStr.length; i++) {
                nums[i] = Integer.parseInt(numsStr[i]);
            }

            Solution obj = new Solution();
            int ans = obj.getPairsCount(nums, k);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends



// User function Template for Java

class Solution {
    int getPairsCount(int[] arr, int sum) {
        // code here
       Map<Integer, Integer> mp = new HashMap<>();
        int cnt = 0;
        
        for (int i : arr) {
            int com = sum - i;
            if (mp.containsKey(com)) {
                cnt += mp.get(com);
            }
            
            mp.put(i, mp.getOrDefault(i, 0) + 1);
        }
        
        return cnt;
    }
}