class Solution {
    public static class Pair{
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
    public static HashMap<Pair,Boolean> mpp = new HashMap<>();
    public static void makeIt2(int[][] grid,int i,int j,int n,int m,Queue<Pair> q,int c,int t){
            if(i + 1 < n && grid[i+1][j] == t && !mpp.getOrDefault(new Pair(i+1,j),false)) {grid[i+1][j] = c;q.offer(new Pair(i+1,j));mpp.put(new Pair(i+1,j),true);}
            if(i - 1 >= 0 && grid[i-1][j] == t && !mpp.getOrDefault(new Pair(i-1,j),false)) {grid[i-1][j] = c;q.offer(new Pair(i-1,j));mpp.put(new Pair(i-1,j),true);}
            if(j + 1 < m && grid[i][j+1] == t && !mpp.getOrDefault(new Pair(i,j+1),false)) {grid[i][j+1] = c;q.offer(new Pair(i,j+1));mpp.put(new Pair(i,j+1),true);}
            if(j - 1 >= 0 && grid[i][j-1] == t && !mpp.getOrDefault(new Pair(i,j-1),false)) {grid[i][j-1] = c;q.offer(new Pair(i,j-1));mpp.put(new Pair(i,j-1),true);}
    }
    public static void dfs(int[][] grid,int i,int j,int n,int m,int c,int t){
        grid[i][j] = c;
        int[] x = {1,-1,0,0};
        int[] y = {0,0,1,-1};
        for(int k = 0;k < 4;k++){
            Pair tmp = new Pair(i+x[k],j+y[k]);
            if(i + x[k] < n && i + x[k] >= 0 && j + y[k] >=0 && j + y[k] < m && grid[i+x[k]][j + y[k]] == t && !mpp.getOrDefault(tmp,false)) {
                grid[i+x[k]][j + y[k]] = c;
                mpp.put(tmp,true);
                dfs(grid,i + x[k],j + y[k],n,m,c,t);
            }
        }
    }
    public static int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int n = grid.length;
        int m = grid[0].length;
        mpp = new HashMap<>();
        int target = grid[sr][sc];
        dfs(grid,sr,sc,n,m,color,target);
        // Queue<Pair> q = new LinkedList<>();
        // q.offer(new Pair(sr,sc));
        // mpp.put(new Pair(sr,sc),true);
        // while(!q.isEmpty()){
        //     Pair c = q.poll();

        //     makeIt2(grid,c.i,c.j,n,m,q,color,target);
        // }
        // return grid;


        return grid;

    }
}