//{ Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            inputLine = br.readLine().trim().split(" ");
            int n = Integer.parseInt(inputLine[0]);
            int x = Integer.parseInt(inputLine[1]);
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().count(arr, n, x);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    
    public static int firstOccurance(int[] arr, int target,int count,int left,int right){
        int mid = (left+right)/2;
        int ans = count;
        if(left <= right){
        if(arr[mid] == target){
            return firstOccurance(arr,target,mid,left,mid - 1);
        }
        else if(arr[mid] > target){
            return firstOccurance(arr,target,count,left,mid - 1);
        }
        else{
            return firstOccurance(arr,target,count,mid + 1,right);
        }
        }
        return ans;
    }
    
    public static int lastOccurance(int[] arr, int target,int count,int left,int right){
        int mid = (left+right)/2;
        int ans = count;
        if(left <= right){
        if(arr[mid] == target){
            return lastOccurance(arr,target,mid,mid + 1,right);
        }
        else if(arr[mid] > target){
            return lastOccurance(arr,target,count,left,mid - 1);
        }
        else{
            return lastOccurance(arr,target,count,mid + 1,right);
        }
        }
        return ans;
    }
    
    
    int count(int[] arr, int n, int x) {
        // code here
        
        
        int i = firstOccurance(arr,x,-1,0,n-1);
        int j = lastOccurance(arr,x,-1,0,n-1);
        if(i == -1 && j == -1){
            return 0;
        }
        int count = 0;
        for(int k = i ; k<=j;k++){
            count++;
        }
        return count;
        
        

        
        
        //BRUTE FORCE
        // int count = 0;
        // for(int i =0;i<n;i++){
        //     if(arr[i] == x){
        //         count++;
        //     }
        // }
        // return count;
    }
}