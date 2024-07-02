class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        List<Integer> ans= new ArrayList<>();
        for(int num:nums){
            mpp.put(num,mpp.getOrDefault(num,0)+1);
            if(mpp.get(num) > Math.floor(n/3)) ans.add(num);
        }
        return ans;
    }
}