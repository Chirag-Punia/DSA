//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int N = sc.nextInt();
            int M[][] = new int[N][N];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    M[i][j] = sc.nextInt();
                }
            }
            System.out.println(new Solution().celebrity(M));
            t--;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find if there is a celebrity in the party or not.
    public int celebrity(int mat[][]) {
        // code here
        int n = mat.length;
        int m = mat[0].length;
        int celeb = -1;
        for(int i=0; i<n;i++){
            boolean ans = true;
            for(int j =0;j<m;j++){
                if(mat[i][j] == 1){
                    ans=false;
                }
            }
            if(ans){
                celeb = i;
                break;
            }
        }
        if(celeb==-1)return -1;
        for(int i = 0;i<n;i++){
            if(mat[i][celeb] != 1 && i!=celeb)return -1;
        }
        return celeb;
    }
}