//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG{
    public static void main(String args[]) throws IOException{
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0){
            int N=sc.nextInt();
            int [][]points=new int[N][3];
            for(int i=0;i<N;i++){
                for(int j=0;j<3;j++){
                    points[i][j]=sc.nextInt();
                }
            }
            Solution obj=new Solution();
            int res=obj.maximumPoints(points,N);
            System.out.println(res);
            
        }
    }
}
// } Driver Code Ends




//User function Template for Java
class Solution{
    //public Map<String,Integer> dp;
    public int[][] dp;
    public int tmp(int[][] p, int last,int day){
        
        if(day >= p.length){
            return 0;
        }
        //String key = day + ":" + last;
        //if(dp.containsKey(key))return dp.get(key);
        if(last != -1 && dp[day][last] != -1)return dp[day][last];
        int maxi = 0,points = 0;
        for(int j = 0;j<3;j++){
            if(j != last){
                points = tmp(p,j,day+1) + p[day][j];
                maxi = Math.max(maxi,points);
            }
        }
        if(last != -1)dp[day][last] = maxi;
        //dp.put((day + ":" + last) , maxi);
        return maxi;
    }
    public int maximumPoints(int points[][],int N){
     
        //dp = new HashMap<>();
        dp = new int[N][3];
        dp[0][0] = points[0][0];
        dp[0][1] = points[0][1];
        dp[0][2] = points[0][2];
         for (int day = 1; day < N; day++) {
            dp[day][0] = points[day][0] + Math.max(dp[day-1][1], dp[day-1][2]);
            dp[day][1] = points[day][1] + Math.max(dp[day-1][0], dp[day-1][2]);
            dp[day][2] = points[day][2] + Math.max(dp[day-1][0], dp[day-1][1]);
        }

      
        return Math.max(dp[N-1][0], Math.max(dp[N-1][1], dp[N-1][2]));
        
    }
}