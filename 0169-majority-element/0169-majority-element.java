class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i = 0;i<nums.length;i++){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0) + 1);
        }
        int[] temp = new int[1];
        mpp.forEach((key,value) -> {
            if(value > (nums.length/2)){
                temp[0] = key;
            }
        });
        return temp[0];
    }
}