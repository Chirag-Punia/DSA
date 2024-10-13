class Solution {
    int[] dp;
    int tmp(int[][] events, int i) {
        if (i == events.length) {
            return 0;
        }
        if(dp[i] != -1)return dp[i];
        int skip = tmp(events, i + 1);
        
        int j = i + 1;
        for(;j < events.length;j++){
            if(events[j][0] >= events[i][1])break;
        }

        int take = events[i][2] + tmp(events, j);

        return dp[i] = Math.max(take, skip);
    }
    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
        int n = startTime.length;
        int[][] events = new int[n][3];
        for(int i = 0;i<n;i++){
            events[i][0] = startTime[i];
            events[i][1] = endTime[i];
            events[i][2] = profit[i];
        }
        dp = new int[n+1];
        Arrays.fill(dp,-1);
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        return tmp(events, 0);
    }
}