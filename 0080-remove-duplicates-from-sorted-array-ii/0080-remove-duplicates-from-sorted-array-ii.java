class Solution {
    public int removeDuplicates(int[] nums) {
        Map<Integer,Integer> mpp = new TreeMap<>();
        for(int num : nums)
            mpp.put(num,mpp.getOrDefault(num,0)+1);
        int[] k = {0};
        mpp.forEach((key,value) -> {
            if(value > 2)
                for(int i = 0;i<2;i++)
                    nums[k[0]++] = key;
            else
                for(int i = 0;i<value;i++)
                    nums[k[0]++] = key;
        });
        return k[0];
    }
}