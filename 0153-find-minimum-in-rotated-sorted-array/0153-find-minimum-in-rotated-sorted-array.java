class Solution {
    int binary(int[] nums, int low, int high, int t) {
        if (low > high)
            return t;
        int mid = (high + low) / 2;
        //sorted part
        if (nums[low] <= nums[mid]) {
            return binary(nums,mid+1,high,Math.min(t,nums[low]));
        } else {
            return binary(nums,low,mid-1,Math.min(t,nums[mid]));
        }
    }
    public int findMin(int[] nums) {
        return binary(nums,0,nums.length-1,Integer.MAX_VALUE);
    }
}