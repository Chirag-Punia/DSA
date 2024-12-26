class Solution {
    int helper(int[] nums,int t,int i,int curr,int[][] dp,int offset){
        if(i >= nums.length){
            return curr == t ? 1 : 0;
        }
        if(dp[i][curr + offset] != -1)return dp[i][curr+offset];
        int pos = helper(nums,t,i+1,curr + nums[i],dp,offset);
        int neg = helper(nums,t,i+1,curr - nums[i],dp,offset);
        return dp[i][curr + offset] = pos+neg;
    }
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int sum = 0;
        for(int a : nums)sum+=a;
        if(Math.abs(target) > sum)return 0;
        int offset = sum;
        int[][] dp = new int[n+1][2*sum + 1];
        for(int[] row : dp)Arrays.fill(row,-1);
        return helper(nums,target,0,0,dp,offset);
    }
}