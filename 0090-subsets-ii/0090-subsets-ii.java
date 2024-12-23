// class Solution {
//     public void temp(int[] nums, int i, Set<List<Integer>> ans, List<Integer> help) {
//         if (i >= nums.length) {
//             ans.add(new ArrayList<>(help));
//             return;
//         }
//         help.add(nums[i]);
//         temp(nums, i + 1, ans, help);
//         help.remove(help.size() - 1);
//         temp(nums, i + 1, ans, help);
//     }

//     public List<List<Integer>> subsetsWithDup(int[] nums) {
//         Arrays.sort(nums);
//         Set<List<Integer>> ans = new HashSet<>();
//         temp(nums, 0, ans, new ArrayList<>());
//         return new ArrayList<>(ans);
//     }
// }
class Solution {
    public void backtrack(int[] nums, int index, List<List<Integer>> ans, List<Integer> current) {
        ans.add(new ArrayList<>(current)); 
        for (int i = index; i < nums.length; i++) {
            if (i > index && nums[i] == nums[i - 1]) {
                continue;
            }
            current.add(nums[i]); 
            backtrack(nums, i + 1, ans, current);
            current.remove(current.size() - 1); 
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums); 
        backtrack(nums, 0, ans, new ArrayList<>());
        return ans;
    }
}
