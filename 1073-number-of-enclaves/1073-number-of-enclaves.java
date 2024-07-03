class Solution {
    public class Pair{
        int i;
        int j;
        Pair(int i,int j){
            this.i=i;
            this.j=j;
        }
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i && j == pair.j;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j);
        }
    }
    public Map<Pair,Boolean> mpp;
    public int cnt;
    public int cnt1;
    public void dfs(int[][]b,int i,int j,int n,int m){
        int[] x = {1,-1,0,0};
        int[] y = {0,0,1,-1};
        for(int k = 0;k < 4;k++){
            Pair tmp = new Pair(i+x[k],j+y[k]);
            if(i + x[k] < n && i + x[k] >= 0 && j + y[k] >=0 && j + y[k] < m && b[i+x[k]][j + y[k]] == 1 && !mpp.getOrDefault(tmp,false)) {
                mpp.put(tmp,true);
                cnt++;
                dfs(b,i + x[k],j + y[k],n,m);
            }
        }
    }
    public int numEnclaves(int[][] b) {
        int n = b.length;
        int m = b[0].length;

        mpp = new HashMap<>();
        cnt = 0;
        cnt1 = 0;

       // Upper Row
        for (int i = 0; i < m; i++) {
            if (b[0][i] == 1) {
                Pair tmp = new Pair(0, i);
                if (!mpp.getOrDefault(tmp, false)) {
                    mpp.put(tmp, true);
                    cnt++;
                    dfs(b, 0, i, n, m);
                }
            }
        }

        // Bottom Row
        for (int i = 0; i < m; i++) {
            if (b[n - 1][i] == 1) {
                Pair tmp = new Pair(n - 1, i);
                if (!mpp.getOrDefault(tmp, false)) {
                    mpp.put(tmp, true);
                    cnt++;
                    dfs(b, n - 1, i, n, m);
                }
            }
        }

        // Left Column
        for (int i = 1; i < n - 1; i++) {
            if (b[i][0] == 1) {
                Pair tmp = new Pair(i, 0);
                if (!mpp.getOrDefault(tmp, false)) {
                    mpp.put(tmp, true);
                    cnt++;
                    dfs(b, i, 0, n, m);
                }
            }
        }

        // Right Column
        for (int i = 1; i < n - 1; i++) {
            if (b[i][m - 1] == 1) {
                Pair tmp = new Pair(i, m - 1);
                if (!mpp.getOrDefault(tmp, false)) {
                    mpp.put(tmp, true);
                    cnt++;
                    dfs(b, i, m - 1, n, m);
                }
            }
        }

        // Count all land cells
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (b[i][j] == 1) cnt1++;
            }
        }

        return cnt1 - cnt;
    }
}