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
        int n = nums.length,maxi = 0;
        for(int i = 0;i<n;i++){
            if(i > maxi) return false;
            maxi = Math.max(maxi,i+nums[i]);
        }
        return true;
    }
}