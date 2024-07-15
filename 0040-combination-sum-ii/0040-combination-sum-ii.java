class Solution {
    public List<List<Integer>> ans;
    public List<Integer> arr;
    public void tmp(int i,int[] nums,int t){
        if(t == 0){
            ans.add(new ArrayList<>(arr));
            return;
        }
        for(int j = i;j<nums.length;j++){
            if(j>i && nums[j-1] == nums[j]) continue;
            if(nums[j] > t) break;
            arr.add(nums[j]);
            tmp(j+1,nums,t-nums[j]);
            arr.remove(arr.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        ans = new ArrayList<>();
        arr = new ArrayList<>();
        Arrays.sort(candidates);
        tmp(0,candidates,target);
        return ans;
    }
}