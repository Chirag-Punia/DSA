class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxi = 0;
        if(n == 1) return true;
        for(int i = 0;i<n;i++){
            int jump = i + nums[i];
            if(i > maxi) return false;
            if(jump > maxi) maxi = jump;
            if(maxi >= n-1) return true;
        }
        return false;
    }
}