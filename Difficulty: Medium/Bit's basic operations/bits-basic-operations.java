//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int a=sc.nextInt();
            int b=sc.nextInt();
            int c=sc.nextInt();
            int d=sc.nextInt();
            Solution obj = new Solution();
            int ans1=obj.XOR(n,m);
            int ans2=obj.check(a,b);
            int ans3=obj.setBit(c,d);
            System.out.println(ans1+" "+ans2+" "+ans3);
        }
    }
}
// } Driver Code Ends


//User function Template for Java


class Solution {
  
    public int XOR(int n, int m)
    { 
        return n^m;
    }
    public int check(int a, int b) {
        return (b & 1 << a-1) != 0 ? 1 : 0;
    }
    public int setBit(int c, int d) {
        return d | (1<<c);
        
    }
}