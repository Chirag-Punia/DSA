class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int cnt = 0;
        int n = nums.length;
        for(int i = 0;i<n;i++){
            int s = 0;
            for(int j = i;j<n;j++){
                s+=nums[j];
                if(s == goal)cnt++;
            }
        }
        return cnt;
    }
}