class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Set<List<Integer>> ans = new HashSet<>();
        List<Integer> arr = new ArrayList<>();
        for(int i = 0;i<n;i++){
            Map<Integer,Integer> mpp = new HashMap<>();
            for(int j = i+1;j<n;j++){
                int rem = -(nums[i] + nums[j]);
                if(mpp.containsKey(rem)){
                    arr.add(nums[i]);
                    arr.add(nums[j]);
                    arr.add(rem);
                    Collections.sort(arr);
                    ans.add(new ArrayList<>(arr));
                    arr.clear();
                }
                mpp.put(nums[j],1);
            }
        }
        return new ArrayList<>(ans);
    }
}