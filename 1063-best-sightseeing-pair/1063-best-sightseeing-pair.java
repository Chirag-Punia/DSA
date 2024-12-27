class Solution {
    public int maxScoreSightseeingPair(int[] values) {
        int n = values.length;
        int maxi = Integer.MIN_VALUE;
        int[] suff = new int[n];
        suff[n-1] = values[n-1] - (n-1);
        for(int i = n-2;i>=0;i--){
            suff[i] = Math.max(suff[i+1],values[i] - i);
        }
        for(int i = 0;i<n-1;i++){
            maxi = Math.max(maxi,values[i]+i + suff[i+1]);
        }
        return maxi;
    }
}