class Solution {
    public static boolean ans;
    public Solution(){
        ans = false;
    }
    public static int ij(int[] nums,int curr,int end){
        int idx = curr;
        int max = nums[curr];
        for(int i = curr;i<=end;i++){
            if(nums[i] > max && i<nums.length){
                max = nums[i];
                idx = i;
            }
            if(i >= nums.length){
                ans = true;
            }
        }
        return idx;
    }
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