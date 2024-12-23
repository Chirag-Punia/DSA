class Solution {
    public int maximumProduct(int[] nums) {
        Arrays.sort(nums);
        
        int n = nums.length;
        int a = nums[n - 1] * nums[n - 2] * nums[n - 3];
        int b = nums[0] * nums[1] * nums[n - 1];
        int c = nums[0] * nums[n-1] * nums[n-2];
        int d = nums[0] * nums[1] * nums[2];
        int e = Math.max(c,d);
        int f = Math.max(e,b);
        return Math.max(a,f);
    }
}