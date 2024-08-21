class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            Map<Integer, Boolean> mpp = new HashMap<>();
            for (int j = i + 1; j < n; j++) {
                int third = -(nums[i] + nums[j]);
                if(mpp.containsKey(third)){
                    List<Integer> tmp = new ArrayList<>();
                    tmp.add(nums[i]);
                    tmp.add(nums[j]);
                    tmp.add(third);
                    Collections.sort(tmp);
                    set.add(tmp);
                }
                mpp.put(nums[j],true);
            }
        }
        return new ArrayList<>(set);
    }
}