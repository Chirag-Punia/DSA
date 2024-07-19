class Solution {
    public int[] dp;
    public int n;
    public int tmp(int[] nums, int i, int start) {
        if (i == 0 && start == n - 1)
            return 0;
        if (i == 0 && start == n - 2)
            return nums[0];
        if (i < 0)
            return 0;
        if (dp[i] != -1)
            return dp[i];
        int pick = nums[i] + tmp(nums, i - 2, start);
        int notPick = tmp(nums, i - 1, start);
        dp[i] = Math.max(pick, notPick);
        return dp[i];
    }

    public int rob(int[] nums) {
        n = nums.length;
        if (n == 1)
            return nums[0];
        if (n == 2)
            return Math.max(nums[0], nums[1]);
        dp = new int[n];
        Arrays.fill(dp, -1);
        int x = tmp(nums, n - 1, n - 1);
        Arrays.fill(dp, -1);
        int y = tmp(nums, n - 2, n - 2);
        return Math.max(x, y);
    }
}