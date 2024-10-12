class Solution {
    Integer dp[][];

    public int maxValue(int[][] events, int k) {
        int n = events.length;
        dp = new Integer[n][k + 1];
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        return solve(events, k, 0, -1);
    }

    public int solve(int[][] events, int k, int curr, int prev) {
        if (curr == events.length || k == 0)
            return 0;
        if (prev == -1 || events[prev][1] < events[curr][0]) {
            
            if (dp[curr][k] != null)
                return dp[curr][k];

            return dp[curr][k] = Math.max(solve(events, k - 1, curr + 1, curr) + events[curr][2],
                    solve(events, k, curr + 1, prev));
        } else
            return solve(events, k, curr + 1, prev);
    }
}