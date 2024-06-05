class Solution {
    public int[] twoSum(int[] nums, int target) {

        HashMap<Integer,Integer> mpp = new HashMap<>();
        int sum = 0;
        int ans[] = new int[2];
        for(int i = 0; i<nums.length;i++){
            int rem = target - nums[i];
            if(mpp.containsKey(rem)){
                ans[0] = mpp.get(rem);
                ans[1] = i;
                break;
            }
            mpp.put(nums[i],i);
        }

        return ans;






        //BRUTE FORCE
        // int sum = 0;
        // int n = nums.length;
        // int[] ans = new int[2];
        // int left = 0;
        // int right = 1;
        // while(left < n ){
        //     while(right < n){
        //     sum =  nums[left] + nums[right];
        //     if(sum == target){
        //         ans[0] = left;
        //         ans[1] = right;
        //         break;
        //     }
        //     right++;
        //     }
        //     left++;
        //     right = left + 1;
        // }
        // return ans;
    }
}