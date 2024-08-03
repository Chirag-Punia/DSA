class Solution {
    public static int[][] dp;
    public static int s;

    static boolean tmp(int arr[], int i, int sum) {
        if (s == sum)
            return true;
        if (i >= arr.length || s > sum)
            return false;
        if (dp[i][s] != -1)
            return dp[i][s] == 1;
        s += arr[i];
        boolean include = tmp(arr, i + 1, sum);
        s -= arr[i];
        boolean exclude = tmp(arr, i + 1, sum);
        dp[i][s] = (include || exclude) ? 1 : 0;
        return dp[i][s] == 1;
    }

    public boolean canPartition(int[] nums) {

        int tmps = 0;
        s = 0;
        for (int n : nums)
            tmps += n;
        if (tmps % 2 != 0)
            return false;
        tmps = tmps / 2;
        dp = new int[nums.length][tmps + 1];
        for (int i = 0; i < nums.length; i++)
            Arrays.fill(dp[i], -1);
        return tmp(nums, 0, tmps);

    }
}