class Solution {
    public int minSwaps(int[] nums) {
        int countOfOnes = 0;
        int n = nums.length;
        for(int x: nums) if(x == 1) countOfOnes++;
        return Math.min(
            solve(nums, n, 0, n - countOfOnes), // group all 0s together
            solve(nums, n, 1, countOfOnes) // group all 1s together
        );
    }

    public int solve(int[] nums, int n, int g, int windowSize) {
        if (windowSize == 0) return 0;
        int swaps = 0;
        for (int i = 0; i < windowSize; i++) {
            if (nums[i] != g) swaps++;
        }
        int minSwaps = swaps;
        for (int i = windowSize; i < n; i++) {
            if (nums[i - windowSize] != g) swaps--;
            if (nums[i] != g) swaps++;
            minSwaps = Math.min(minSwaps, swaps);
        }
        return minSwaps;
    }
}