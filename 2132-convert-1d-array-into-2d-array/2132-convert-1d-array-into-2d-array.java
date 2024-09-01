class Solution {
    public int[][] construct2DArray(int[] o, int m, int n) {
        if(m*n != o.length)return new int[][]{};
        int[][] ans = new int[m][n];
        int k = 0;
        for(int i = 0;i<m;i++){
            for(int j = 0;j<n;j++){
                ans[i][j] = o[k];
                k++;
            }
        }
        return ans;
    }
}