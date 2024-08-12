class Solution {
    public int nCr(int n, int r) {
        int res = 1;
        for (int i = 0; i < r; i++) {
            res = res * (n - i);
            res = res / (i + 1);
        }
        return res;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> arr = new ArrayList<>();
            for (int j = 0; j < i + 1; j++) {
                arr.add(nCr(i, j));
            }
            ans.add(arr);
        }
        return ans;
    }
}