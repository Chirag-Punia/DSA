import java.util.*;
//https://www.naukri.com/code360/problems/1072980?topList=striver-sde-sheet-problems&utm_source=striver&utm_medium=website&leftPanelTabValue=SUBMISSION
public class Solution {
	public static int[][] dp;
	public static int tmp(ArrayList<Integer> values, ArrayList<Integer> weights,int n,int threshold, int i){
		if(i == n){
			return 0;
		}
		if(dp[i][threshold] != -1)return dp[i][threshold];
		int exclude = tmp(values,weights,n,threshold,i+1);
		int include = 0;
		if(weights.get(i) <= threshold)
			include = values.get(i) + tmp(values,weights,n,threshold-weights.get(i),i+1);
		
		return dp[i][threshold] = Math.max(include , exclude);
	}
	public static int maxProfit(ArrayList<Integer> values, ArrayList<Integer> weights, int n, int threshold) {
		// Write your code here.
		dp = new int[n][threshold+1];
		for(int[] i : dp)
			Arrays.fill(i,-1);
		return tmp(values, weights, n, threshold, 0);
		
	}
}
