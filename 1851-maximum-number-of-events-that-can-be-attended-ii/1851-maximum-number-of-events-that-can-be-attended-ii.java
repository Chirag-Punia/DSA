import java.util.Arrays;

class Solution {
    int[][] dp;
    int tmp(int[][] events, int i, int k) {
        if (k == 0 || i == events.length) {
            return 0;
        }
        if(dp[i][k] != -1)return dp[i][k];
        int skip = tmp(events, i + 1, k);
        
        int j = i + 1;
        for(;j < events.length;j++){
            if(events[j][0] > events[i][1])break;
        }

        int take = events[i][2] + tmp(events, j, k - 1);

        return dp[i][k] = Math.max(take, skip);
    }

    public int maxValue(int[][] events, int k) {
        dp = new int[events.length+1][k+1];
        for(int[] row : dp)Arrays.fill(row,-1);
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        return tmp(events, 0, k);
    }
}
