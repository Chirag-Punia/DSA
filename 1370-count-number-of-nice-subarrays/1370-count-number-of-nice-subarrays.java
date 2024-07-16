class Solution {
    public int func(int[] nums, int goal) {
        int left = 0;
        int right = 0;
        int cnt = 0;
        int s = 0;
        int n = nums.length;
        if (goal < 0)
            return 0;
        while (right < n) {
            s += nums[right]%2;
            while (s > goal) {
                s -= nums[left]%2;
                left++;
            }
            cnt += right - left + 1;
            right++;
        }
    return cnt;
    }
    public int numberOfSubarrays(int[] nums, int k) {
        return func(nums,k) - func(nums,k-1);
    }
}