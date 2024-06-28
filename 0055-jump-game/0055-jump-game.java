class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length,maxi = 0;
        for(int i = 0;i<n;i++){
            if(i > maxi) return false;
            maxi = Math.max(maxi,i+nums[i]);
        }
        return true;
    }
}