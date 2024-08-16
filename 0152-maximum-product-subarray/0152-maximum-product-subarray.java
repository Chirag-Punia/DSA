class Solution {
    public int maxProduct(int[] nums) {
        long ans = Long.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){     
            long prod = nums[i];
            ans = Math.max(ans,prod);
            for(int j = i + 1;j<nums.length;j++){
                prod = prod * nums[j];
                if (prod > Integer.MAX_VALUE || prod < Integer.MIN_VALUE) {
                    break;
                }
                ans = Math.max(ans,prod);
            }
        }
        return (int)ans;
    }
}