//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

class Rat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int[][] a = new int[n][n];
            for (int i = 0; i < n; i++)
                for (int j = 0; j < n; j++) a[i][j] = sc.nextInt();

            Solution obj = new Solution();
            ArrayList<String> res = obj.findPath(a);
            Collections.sort(res);
            if (res.size() > 0) {
                for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
                System.out.println();
            } else {
                System.out.println(-1);
            }
        }
    }
}

// } Driver Code Ends

class Solution {
    static ArrayList<String> ls;
    public ArrayList<String> findPath(int[][] mat) {
       ls=new ArrayList<>();
       int n=mat.length;
       int m=mat[0].length;
       if(mat[0][0]==0){
           return ls;
       }
       boolean vis[][]=new boolean[n][m];
       solve(mat,0,0,vis,n,m,"");
       return ls;
    }
    public static void solve(int mat[][],int i,int j,boolean vis[][],int n,int m,String ans){
         if(i<0||i>=n||j<0||j>=m||vis[i][j]||mat[i][j]==0){
             return ;
         }
        
        if(i==n-1&&j==m-1){
            ls.add(ans);
            return ;
        }
        
        vis[i][j]=true;
        solve(mat,i-1,j,vis,n,m,ans+'U');
        solve(mat,i+1,j,vis,n,m,ans+'D');
        solve(mat,i,j-1,vis,n,m,ans+'L');
        solve(mat,i,j+1,vis,n,m,ans+'R');
        vis[i][j]=false;
         
    }
}