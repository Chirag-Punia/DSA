class Solution {
    public class Pair{
        int i;
        int j;
        int level;

    Pair(int i,int j,int l){
            this.i=i;
            this.j=j;
            this.level=l;
        }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pair pair = (Pair) o;
        return i == pair.i && j == pair.j;
    }

    @Override
    public int hashCode() {
        return Objects.hash(i, j);
    }}

    public int[][] vis;
    public Map<Pair, Boolean> mpp;

    public int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int[] x = { 1, -1, 0, 0 };
        int[] y = { 0, 0, 1, -1 };

        vis = new int[n][m];
        mpp = new HashMap<>();

        Queue<Pair> q = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 0) {
                    Pair tmp = new Pair(i, j,0);
                    q.offer(tmp);
                    mpp.put(tmp,true);
                }
            }
        }
        while (!q.isEmpty()) {
            Pair c = q.poll();
            vis[c.i][c.j] = c.level;
            for (int k = 0; k < 4; k++) {
                Pair tmp = new Pair(c.i + x[k], c.j + y[k],c.level+1);
                if (c.i + x[k] < n && c.i + x[k] >= 0 && c.j + y[k] >= 0 && c.j + y[k] < m
                        && !mpp.getOrDefault(tmp, false)) {
                    q.offer(tmp);
                    mpp.put(tmp,true);
                }
            }
            

        }
        return vis;
    }
}