class Solution {
    public int[] missingRolls(int[] rolls, int mean, int n) {
        int sum = 0;
        int[] ans = new int[n];
        int k = 0;
        for(int i : rolls)
            sum += i;
        sum = (mean*(rolls.length+n)) - sum;
        if(n*6 < sum || sum < n)return new int[]{};
        for(int i = 0;i<n;i++){
            ans[i] = sum/n;
        }
        for(int i = 0;i<sum%n;i++){
            ans[i]++;
        }
        return ans;
    }
}