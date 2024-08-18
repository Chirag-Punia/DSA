//{ Driver Code Starts
import java.io.*;
import java.util.*;

  public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n];
            String[] inputLine = br.readLine().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            System.out.println(new Solution().maxProduct(arr, n));
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find maximum product subarray
    long maxProduct(int[] arr, int n) {
        long maxproduct=arr[0];
        long minproduct=arr[0];
        long result=arr[0];
        for(int i=1;i<n;i++)
        {
            int current=arr[i];
            if(current<0)
            {
                long temp=maxproduct;
                maxproduct=minproduct;
                minproduct=temp;
            }
            
            maxproduct=Math.max(current,current*maxproduct);
            minproduct=Math.min(current,current*minproduct);
            result=Math.max(result,maxproduct);
        }
    
    
    return result;
    }
}