//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.longestPalin(S));
        }
    }
}

// } Driver Code Ends




//User function Template for Java

class Solution{
    static String longestPalin(String S){
        
        int n = S.length();  // Use length() instead of size() for strings in Java
    int start = n;
    int ans = 0;

    for (int i = 0; i < n; i++) {
        int l = i - 1;
        int r = i + 1;
        int cans = 1;

        // Odd length palindrome
        while (l > -1 && r < n && S.charAt(l) == S.charAt(r)) {
            cans += 2;
            r++;
            l--;
        }

        if (cans > ans) {
            ans = cans;
            start = l + 1;
        } else if (cans == ans && l + 1 < start) {
            start = l + 1;
        }

        l = i - 1;
        r = i;
        cans = 0;

        // Even length palindrome
        while (l > -1 && r < n && S.charAt(l) == S.charAt(r)) {
            cans += 2;
            r++;
            l--;
        }

        if (cans > ans) {
            ans = cans;
            start = l + 1;
        } else if (cans == ans && l + 1 < start) {
            start = l + 1;
        }
    }

    return S.substring(start, start + ans);
        
    }
}