class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, maxLen = 0, flipCount = 0,n=nums.length;
        while (right < n) {
            if (nums[right] == 0)
                ++flipCount;
            while (k < flipCount) {
                if (nums[left] == 0)
                    --flipCount;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }

        return maxLen;

    }
}