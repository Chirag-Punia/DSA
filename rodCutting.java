import java.util.*;
//https://www.naukri.com/code360/problems/rod-cutting-problem_800284?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTabValue=SUBMISSION
public class Solution {
	public static int tmp(int[] cuts,int i,int n,int[][] dp) {
        if(i == 0){
            return n*cuts[0];
        }
		if(dp[i][n] != -1)return dp[i][n];
        int notTake = tmp(cuts,i-1,n,dp);
        int take = Integer.MIN_VALUE;
        if(i + 1 <= n)
            take = cuts[i] + tmp(cuts,i,n-(i + 1),dp);
        return dp[i][n] = Math.max(take,notTake);
    }
	public static int cutRod(int price[], int n) {
		// Write your code here.
		int[][] dp = new int[price.length][n+1];
		for(int[] row : dp)
			Arrays.fill(row,-1);
		return tmp(price,price.length -1,n,dp);
	}
}
