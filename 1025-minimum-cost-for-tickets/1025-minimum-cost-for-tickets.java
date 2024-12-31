class Solution {
    private int[] dp = new int[366];

    private int solve(int ind, int[] days, int[] costs) {
        if (ind >= days.length) return 0;
        if (dp[ind] != -1) return dp[ind];

        int oneDay = costs[0] + solve(ind + 1, days, costs);

        int day = lowerBound(days, days[ind] + 7);
        int sevenDays = costs[1] + solve(day, days, costs);

        day = lowerBound(days, days[ind] + 30);
        int thirtyDays = costs[2] + solve(day, days, costs);

        dp[ind] = Math.min(oneDay, Math.min(sevenDays, thirtyDays));
        return dp[ind];
    }

    private int lowerBound(int[] days, int target) {
        int low = 0, high = days.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (days[mid] >= target) high = mid;
            else low = mid + 1;
        }
        return low;
    }

    public int mincostTickets(int[] days, int[] costs) {
        Arrays.fill(dp, -1);
        return solve(0, days, costs);
    }
}