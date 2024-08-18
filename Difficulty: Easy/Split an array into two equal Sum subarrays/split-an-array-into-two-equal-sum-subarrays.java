//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String[] s = br.readLine().trim().split(" ");

            int[] arr = new int[s.length];
            for (int i = 0; i < arr.length; i++) arr[i] = Integer.parseInt(s[i]);

            Solution obj = new Solution();
            boolean res = obj.canSplit(arr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends


class Solution {
    public boolean canSplit(int arr[]) {
        // code here
        int sum = 0,n = arr.length;
        for(int i : arr)sum+=i;
        if(sum % 2 != 0)return false;
        sum = sum / 2;
        int left = 0,right = 0,tmp = 0;
        for(int i : arr){
            tmp += i;
            if(tmp == sum)return true;
            if(tmp > sum)break;
        }
        tmp = 0;
        for(int i = n-1;i>=0;i--){
            tmp += arr[i];
            if(tmp == sum)return true;
            if(tmp > sum)break;
        }
        return false;
    }
}