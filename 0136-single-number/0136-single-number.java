class Solution {
    public int singleNumber(int[] nums) {
        int n = nums.length;
        HashMap<Integer,Integer> mpp = new HashMap<>();
        for(int i = 0; i<n;i++){
            mpp.put(nums[i],mpp.getOrDefault(nums[i],0)+1);
        }
        int[] temp = new int[1];
        mpp.forEach((key,value) -> {
            if(value == 1){
                temp[0] = key;
            }
        });

        return temp[0];


        
    }
}