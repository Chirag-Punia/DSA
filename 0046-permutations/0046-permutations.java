class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> arr = new ArrayList<>();
    void helper(int[] nums,int i){
        if(i == nums.length){
            for(int m = 0;m<nums.length;m++)arr.add(nums[m]);
            ans.add(new ArrayList<>(arr));
            arr.clear();
            return;
        }
        for(int k = i;k<nums.length;k++){
            swap(nums,i,k);
            helper(nums,i+1);
            swap(nums,i,k);
        }
    }
    void swap(int[] nums,int i,int j){
        int t = nums[i];
        nums[i] = nums[j];
        nums[j] = t;
    }
    public List<List<Integer>> permute(int[] nums) {
        arr.clear();
        ans.clear();
        helper(nums,0);
        return ans;
    }
}