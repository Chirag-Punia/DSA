class Solution {
    public int[] twoSum(int[] nums, int target) {
        int sum = 0;
        int n = nums.length;
        int[] ans = new int[2];
        int left = 0;
        int right = 1;
        while(left < n ){
            while(right < n){
            sum =  nums[left] + nums[right];
            if(sum == target){
                ans[0] = left;
                ans[1] = right;
                break;
            }
            right++;
            }
            left++;
            right = left + 1;
        }
        return ans;
    }
}