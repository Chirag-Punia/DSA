class Solution {
    int ans;
    List<Integer> arr = new ArrayList<>();
    Map<String, Integer> dp = new HashMap<>();

    int tmp(int[] nums, int i, int prev) {
        String key = i + "," + prev;
        if (i >= nums.length) {
            return 0;
        }
        if (dp.containsKey(key))
            return dp.get(key);
        int include = 0,len = 0;
        len = tmp(nums, i + 1, prev);
        if (prev == -1 || nums[prev] < nums[i])
            len = Math.max(len, 1 + tmp(nums, i + 1, i));
        dp.put(key, len);
        return len;
    }
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

    public int lengthOfLIS(int[] nums) {
        ans = 0;
        dp.clear();
        arr.clear();
        return tabulation(nums, nums.length);
    }
}