class Solution {
    boolean binary(int[] nums, int low, int high, int target) {
        if (low > high)
            return false;
        int mid = (high + low) / 2;
        if (nums[mid] == target)
            return true;
        if (nums[mid] == nums[low] && nums[mid] == nums[high]) {
            return binary(nums, low + 1, high - 1, target);
        }
        if (nums[low] <= nums[mid]) {
            if (target >= nums[low] && target <= nums[mid]) {
                return binary(nums, low, mid - 1, target);
            } else {
                return binary(nums, mid + 1, high, target);
            }
        } else {
            if (target >= nums[mid] && target <= nums[high]) {
                return binary(nums, mid + 1, high, target);
            } else {
                return binary(nums, low, mid - 1, target);
            }
        }
    }

    public boolean search(int[] nums, int target) {
        return binary(nums, 0, nums.length - 1, target);
    }
}