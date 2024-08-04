class Solution {
    public int s;
    public int tmp(int[] nums,int target,int i,int currSum){
        if(i<0 && target == currSum)return 1;
        if(i < 0)return 0;
        int pos = tmp(nums,target,i-1,currSum+nums[i]);
        int neg = tmp(nums,target,i-1,currSum-nums[i]);
        return pos+neg;
    }
    public int findTargetSumWays(int[] nums, int target) {
        s = 0;
        return tmp(nums,target,nums.length-1,0);
    }
}