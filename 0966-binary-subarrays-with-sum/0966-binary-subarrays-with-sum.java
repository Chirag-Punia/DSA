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
            s += nums[right];
            while (s > goal) {
                s -= nums[left];
                left++;
            }
            cnt += right - left + 1;
            right++;
        }
    return cnt;
    }

    public int numSubarraysWithSum(int[] nums, int goal) {
        // int cnt = 0;
        // int n = nums.length;
        // for (int i = 0; i < n; i++) {
        //     int s = 0;
        //     for (int j = i; j < n; j++) {
        //         s += nums[j];
        //         if (s == goal)
        //             cnt++;
        //     }
        // }
        // return cnt;
        int a = func(nums,goal);
        int b = func(nums,goal-1);
        return a - b;
    }

}