class Solution {
    public List<List<Integer>> ans;
    List<Integer> arr;
    public void tmp(int[] c,int t,int i){
        if(i >= c.length){
            if(t == 0){
                ans.add(new ArrayList<>(arr));
            }
            return;
        }
        if(c[i] <= t){
            arr.add(c[i]);
            tmp(c,t-c[i],i);
            arr.remove(arr.size()-1);
        } 
        tmp(c,t,i+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        arr = new ArrayList<>();
        tmp(candidates,target,0);
        return ans;
    }
}