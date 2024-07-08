//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            int k;
            k = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            String res = obj.binaryPalindrome(n, k);

            System.out.println(res);
        }
    }
}

// } Driver Code Ends




class Solution {
    public static String binaryPalindrome(int n, int k) {
        // code here
        
        StringBuilder sb = new StringBuilder();
        
        for(int i = 0 ; i < n ; i++){
            sb.append('0');
        }
        int i = 0;
        while(i < n){
            sb.setCharAt(i , '1');
            sb.setCharAt(n - i - 1 , '1');
            i += k;
        }
        
        return sb.toString();
    }
}