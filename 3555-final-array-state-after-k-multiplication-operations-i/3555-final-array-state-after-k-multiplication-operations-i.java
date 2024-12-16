class Solution {
    int mini(int[] nums){
        int min = Integer.MAX_VALUE;
        int ans = 0;
        for(int i = 0;i<nums.length;i++){
            if(nums[i] < min){
                min = nums[i];
                ans = i;
            }

        }
        return ans;
    }
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        for(int i = 0;i<k;i++){
            int j = mini(nums);
            nums[j] = nums[j] * multiplier;
        }
        return nums;
    }
}