class Solution {
    int binary(int[] nums, int low, int high) {
        if (low == high) {
            return low;
        }
        
        int mid = (high + low) / 2;
        
        if (nums[mid] > nums[mid + 1]) {
            return binary(nums, low, mid);
        } else {
            return binary(nums, mid + 1, high);
        }
    }

    public int findPeakElement(int[] nums) {
        return binary(nums, 0, nums.length - 1);
    }
}
