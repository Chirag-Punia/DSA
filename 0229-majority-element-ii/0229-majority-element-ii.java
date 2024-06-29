class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int num:nums)mpp.put(num,mpp.getOrDefault(num,0)+1);
        List<Integer> ans= new ArrayList<>();
        mpp.forEach((key,value) -> {
            if(value > Math.floor(n/3))ans.add(key);
        });
        return ans;
    }
}