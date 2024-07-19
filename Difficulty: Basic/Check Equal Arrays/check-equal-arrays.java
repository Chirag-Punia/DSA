//{ Driver Code Starts
// Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            String line1 = read.readLine().trim();
            String[] numsStr1 = line1.split(" ");
            int[] arr1 = new int[numsStr1.length];
            for (int i = 0; i < numsStr1.length; i++) {
                arr1[i] = Integer.parseInt(numsStr1[i]);
            }

            String line2 = read.readLine().trim();
            String[] numsStr2 = line2.split(" ");
            int[] arr2 = new int[numsStr2.length];
            for (int i = 0; i < numsStr2.length; i++) {
                arr2[i] = Integer.parseInt(numsStr2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.check(arr1, arr2) ? "true" : "false");
        }
    }
}
// } Driver Code Ends



// User function Template for Java

class Solution {
    // Function to check if two arrays are equal or not.
    public static boolean check(int[] arr1, int[] arr2) {
        int x=arr1.length;
        // Your code here
        HashMap <Integer,Integer> mpp = new  HashMap<>();
        for(int i=0;i<x;i++){
            if(mpp.containsKey(arr1[i])){
                mpp.put(arr1[i],mpp.get(arr1[i])+1);
            }
            else
            {
            mpp.put(arr1[i],1);
            }
        }
        int c=0;
        for(int i=0;i<x;i++){
            Integer key = arr2[i];
            if(mpp.containsKey(key) && mpp.get(key)>0){
                mpp.put(key,mpp.get(key)-1);
                c++;
                
            }
            else{
                
                break;
            }
        }
        if(c==x){
            return true;
        }
        else{
            return false;
        }
        
    }
}