import java.util.ArrayList;
class Solution {
    public List<List<Integer>> ans;
    public List<Integer> arr;
    public void tmp(int i,int[] nums){
        if(i >= nums.length){
            ans.add(new ArrayList<>(arr));
            return;
        }
        arr.add(nums[i]);
        tmp(i+1,nums);
        arr.remove(arr.size() - 1);
        tmp(i+1,nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        ans = new ArrayList<>();
        arr = new ArrayList<>();
        tmp(0,nums);
        return ans;
    }
}