class Solution {
    public int longestOnes(int[] nums, int k) {





        int ans = 0;
        for(int i = 0;i < nums.length;i++){
            int flipCount = 0;
            int maxLen = 0;
            for(int j = i;j < nums.length;j++){
                if(nums[j] == 1)ans = Math.max(ans,++maxLen);
                else if(nums[j] == 0 && flipCount < k)
                {ans = Math.max(ans,++maxLen);++flipCount;}
                else break;
            }
        }
        return ans;
    }
}