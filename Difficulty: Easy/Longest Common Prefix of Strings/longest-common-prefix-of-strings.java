//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String arr[] = read.readLine().trim().split(" ");

            Solution ob = new Solution();
            System.out.println(ob.longestCommonPrefix(arr));
        }
    }
}
// } Driver Code Ends



// User function Template for Java

class Solution {
    public String longestCommonPrefix(String arr[]) {
        // code here
        String s=arr[0];
        for(int i=1;i<arr.length;i++){
            while(arr[i].indexOf(s)!=0){
                s=s.substring(0,s.length()-1);
            }
            if(s.length()==0){
                return "-1";
            }
        }
        return s;
    }
}