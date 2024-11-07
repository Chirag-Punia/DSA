class Solution {
    public int largestCombination(int[] candidates) {
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<25;i++){
            int cnt = 0;
            for(int num : candidates){
                if((num & (1 << i)) != 0){
                    cnt++;
                }
            }
            ans = Math.max(cnt,ans);
        }
        return ans;
    }
    
}