class Solution {
    public int removeDuplicates(int[] nums) {
        //j will track replacement index and tracks number of elemet replaced
        int j = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}