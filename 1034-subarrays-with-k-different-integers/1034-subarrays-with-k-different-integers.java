class Solution {
      private int func(int[] nums, int goal) {
        int left = 0, right = 0, cnt = 0, n = nums.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();

        while (right < n) {
            int curr = nums[right];
            mpp.put(curr, mpp.getOrDefault(curr, 0) + 1);

            while (mpp.size() > goal) {
                mpp.put(nums[left], mpp.get(nums[left]) - 1);
                if (mpp.get(nums[left]) == 0) mpp.remove(nums[left]);
                left++;
            }

            cnt += right - left + 1;
            right++;
        }
        
        return cnt;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {
        return func(nums,k) - func(nums,k-1);
    }
}