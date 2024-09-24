//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String line = sc.nextLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            // Convert ArrayList to array
            Integer[] arr = new Integer[array.size()];
            array.toArray(arr);

            Solution ob = new Solution();

            // Call totalFruits method and print result
            Integer ans = ob.totalFruits(arr);
            System.out.println(ans);
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int totalFruits(Integer[] arr) {
        // code here
        int left = 0;
        int right = 0;
        int n = arr.length;
        int ans = Integer.MIN_VALUE;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        while(right < n){
            int curr = arr[right];
            mpp.put(curr,mpp.getOrDefault(curr,0) + 1);
            while(mpp.size() > 2){
                int x = arr[left];
                mpp.put(x,mpp.get(x) - 1);
                left++;
                if(mpp.get(x) == 0)mpp.remove(x);
            }
            ans = Math.max(right - left + 1,ans);
            right++;
        }
        return ans;
    }
}