class Solution {
    public List<List<Integer>> ans;
    public List<Integer> arr;
    public void tmp(int i,int[] nums){
        ans.add(new ArrayList<>(arr));
        for(int j = i;j<nums.length;j++){
            if(j>i && nums[j-1] == nums[j]) continue;
            arr.add(nums[j]);
            tmp(j+1,nums);
            arr.remove(arr.size() - 1);
        }        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        ans = new ArrayList<>();
        arr = new ArrayList<>();
        Arrays.sort(nums);
        tmp(0,nums);
        return ans;
    }
}