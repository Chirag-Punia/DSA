class Solution {
    public HashMap<String,Integer> dp;

    public int tmp(int[] nums, int target, int i, int currSum) {
        String key = i+","+currSum;
        if (dp.containsKey(key))
            return dp.get(key);
        if (i < 0 && target == currSum)
            return 1;
        if (i < 0)
            return 0;
        int pos = tmp(nums, target, i - 1, currSum + nums[i]);
        int neg = tmp(nums, target, i - 1, currSum - nums[i]);
        dp.put(key,pos+neg);
        return dp.get(key);
    }

    public int findTargetSumWays(int[] nums, int target) {
        dp = new HashMap<>();
        return tmp(nums, target, nums.length - 1, 0);
    }
}