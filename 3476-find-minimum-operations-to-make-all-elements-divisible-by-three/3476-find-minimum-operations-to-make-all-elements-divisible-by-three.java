class Solution {
    public int minimumOperations(int[] nums) {
        int cnt = 0;
        for(int num : nums){
            if(num % 3 == 1 || num % 3 == 2){
                cnt++;
            }
        }
        return cnt;
    }
}