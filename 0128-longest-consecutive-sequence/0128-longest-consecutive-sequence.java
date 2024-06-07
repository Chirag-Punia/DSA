class Solution {
    public int longestConsecutive(int[] nums) {

        int count = 0;
        int ans = 0;
        HashSet<Integer> hash = new HashSet<>();

        for(int i = 0; i< nums.length;i++){
            hash.add(nums[i]);
        }
        //just wow
        for(int ele :hash){
            if(!hash.contains(ele-1)){
                count = 1;
                int x = ele;
                while(hash.contains(++x)){
                    count++;
                }
                ans = Math.max(ans,count);
            }
        }
        return ans;
    }
}