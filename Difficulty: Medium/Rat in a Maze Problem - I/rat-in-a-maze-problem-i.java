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
    public void tmp(int[][] mat,int i,int j,StringBuilder sb,ArrayList<String> ans,Map<String,Boolean> mpp){
        
        if(i == mat.length - 1 && j == mat[0].length - 1){
            ans.add(sb.toString());
            return;
        }
        if(i > mat.length - 1 || j > mat[0].length - 1)return;
        int[] x = {0,0,1,-1};
        int[] y = {1,-1,0,0};
        for(int k = 0;k<4;k++){
            int newX = i + x[k];
            int newY = j + y[k];
            String key = newX + "," + newY;
            if(!mpp.getOrDefault(key,false)  && newX < mat.length && newX >= 0 && newY < mat[0].length && newY >= 0 && mat[newX][newY] == 1){
                if(k == 0) sb.append('R');
                if(k == 1) sb.append('L');
                if(k == 2) sb.append('D');
                if(k == 3) sb.append('U');
                mpp.put(key , true);
                tmp(mat,newX,newY,sb,ans,mpp);
                sb.deleteCharAt(sb.length() - 1);
                mpp.put(key, false);
            }
        }
        
    }
    public ArrayList<String> findPath(int[][] mat) {
        // Your code here
        ArrayList<String> arr = new ArrayList<>();
        Map<String,Boolean> mpp = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        if (mat[0][0] == 1) {
            mpp.put("0,0", true);
            tmp(mat, 0, 0, sb, arr, mpp);
        }
        return arr;
        
    }
}