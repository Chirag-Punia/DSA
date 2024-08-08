class Solution {
    // int ans;
    // List<Integer> arr = new ArrayList<>();
    // Map<String, Integer> dp = new HashMap<>();

    // int tmp(int[] nums, int i, int prev) {
    //     String key = i + "," + prev;
    //     if (i >= nums.length) {
    //         return 0;
    //     }
    //     if (dp.containsKey(key))
    //         return dp.get(key);
    //     int include = 0,len = 0;
    //     len = tmp(nums, i + 1, prev);
    //     if (prev == -1 || nums[prev] < nums[i])
    //         len = Math.max(len, 1 + tmp(nums, i + 1, i));
    //     dp.put(key, len);
    //     return len;
    // }
    int tabulation(int[] nums,int n){
        int[][] dp = new int[n+1][n+1];
        for(int[] r: dp)Arrays.fill(r,0);
        for(int i = n - 1;i>=0;i--){
            for(int prev = i - 1;prev>=-1;prev--){
                dp[i][prev+1] = dp[i+1][prev+1];
                if(prev == -1 || nums[prev] < nums[i]){
                    dp[i][prev + 1] = Math.max(dp[i][prev + 1] ,1 + dp[i+1][i+1]);
                }
            }
        }
        return dp[0][0];
    }
    int tabulation2(int[] nums,int n){
        int[] ahead = new int[n+1];
        int[] prev = new int[n+1];
        for(int i = 0;i<=n;i++)ahead[i] = 0;
        for(int i = n - 1;i>=0;i--){
            for(int prev_idx = i - 1;prev_idx>=-1;prev_idx--){
                prev[prev_idx+1] = ahead[prev_idx+1];
                if(prev_idx == -1 || nums[prev_idx] < nums[i]){
                    prev[prev_idx + 1] = Math.max(prev[prev_idx + 1] ,1 + ahead[i+1]);
                }
            }
            for(int j = 0;j<=n;j++)ahead[j] = prev[j];
        }
        return ahead[0];
    }
    public int lengthOfLIS(int[] nums) {
        // ans = 0;
        // dp.clear();
        // arr.clear();
        return tabulation2(nums, nums.length);
    }
}