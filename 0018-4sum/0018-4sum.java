class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        int n = nums.length;
        Arrays.sort(nums);
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                Map<Long, Boolean> mpp = new HashMap<>();
                for (int k = j + 1; k < n; k++) {
                    long sum = (long) nums[i] + (long) nums[j] + (long) nums[k];
                    long fourth = (long) target - sum;
                    if (mpp.containsKey(fourth)) {
                        List<Integer> tmp = new ArrayList<>();
                        tmp.add(nums[i]);
                        tmp.add(nums[j]);
                        tmp.add(nums[k]);
                        tmp.add((int) fourth);
                        Collections.sort(tmp);
                        set.add(tmp);
                    }
                    mpp.put((long) nums[k], true);
                }
            }
        }
        return new ArrayList<>(set);
    }
}
