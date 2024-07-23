class Solution {
    public int[] frequencySort(int[] nums) {
        Map<Integer,Integer> mpp1 = new HashMap<>();
        for(int num : nums){
            mpp1.put(num,mpp1.getOrDefault(num,0)+1);
        }
        Map<Integer,Integer> mpp = new TreeMap<>(new Comparator<Integer>(){
            @Override
            public int compare(Integer key1, Integer key2){
                int tmp = mpp1.get(key1).compareTo(mpp1.get(key2));
                if(tmp != 0)return tmp;
                else return key2.compareTo(key1);
            }
        });
        mpp.putAll(mpp1);
        int[] ans = new int[nums.length];
        int[] k = {0};
        mpp.forEach((key,value) -> {
            for(int i = 0;i<value;i++){
                ans[k[0]++] = key;
            }
        });
        return ans;
    }
}