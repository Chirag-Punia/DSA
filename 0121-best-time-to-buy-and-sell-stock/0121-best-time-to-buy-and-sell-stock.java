class Solution {
    public int maxProfit(int[] arr) {
        int n = arr.length;
        int min = Integer.MAX_VALUE;
        int maxPRO = 0;
        for(int i = 0;i<n;i++){
            min = Math.min(min,arr[i]);
            maxPRO = Math.max(maxPRO,arr[i] - min);
        }
        return maxPRO;
        


    //     BRUTE FORCE
    //     int ans = 0;
    //     for(int i = 0; i<n-1;i++){
    //         for(int j = i+1;j<n;j++){
    //             int diff = prices[j] - prices[i];
    //             ans = Math.max(ans,diff);
    //         }
    //     }
    //     return ans;
    // }


}
}