class Solution {
    public List<List<Integer>> ans;
    public List<Integer> arr;
    public void tmp(int i,int[] nums,int t,int k){
        if(t == 0 && arr.size() == k){
            ans.add(new ArrayList<>(arr));
            return;
        }
        if(t == 0){
            return;
        }
        for(int j = i;j<nums.length;j++){
            if(j>i && nums[j-1] == nums[j]) continue;
            if(nums[j] > t) break;
            arr.add(nums[j]);
            tmp(j+1,nums,t-nums[j],k);
            arr.remove(arr.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        ans = new ArrayList<>();
        arr = new ArrayList<>();
        int[] a = new int[9];
        for(int i = 1;i<=9;i++){
            a[i-1] = i;
        }
        tmp(0,a,n,k);
        return ans;
    }
}