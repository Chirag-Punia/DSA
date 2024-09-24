class Solution {
    public int longestOnes(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int n = nums.length;
        int c = 0;
        int ans = Integer.MIN_VALUE;
        while(right < n){
            if(nums[right] == 0)
                ++c;
            while(c > k){
                if(nums[left] == 0)
                    --c;
                left++;
            }
            ans = Math.max(ans, right - left + 1);
            right++;

        }
        return ans;
    }
}