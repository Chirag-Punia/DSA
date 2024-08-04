class Solution {
    int currSum;
    List<Integer> allSum;
    static final int MOD = 1000000007;
    public int rangeSum(int[] nums, int n, int left, int right) {
        allSum = new ArrayList<>();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            currSum = 0;
            for (int j = i; j < n; j++) {
                currSum += nums[j];
                allSum.add(currSum);
            }
        }
        Collections.sort(allSum);
        for (int i = left - 1; i < right; i++)
            ans = (ans+allSum.get(i))%MOD;
        return ans ;
    }
}