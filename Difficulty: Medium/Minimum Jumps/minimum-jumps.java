//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr, size));
        }
    }
}

// } Driver Code Ends




class Solution {
    static int minJumps(int[] arr, int n) {
        // your code here
        if(arr.length==1) return 0;
        if(arr[0]==0) return -1; 
        int pos=0;
        int i=0;
        int maxDis=0;
        int jump=0;
        while(i<n){
            maxDis=Math.max(maxDis, arr[i]+i);
            if(i==pos){
                pos=maxDis;
                jump++;
            }
            if(pos>=n-1) return jump;
            i++;
        }
        return -1;
    }
}