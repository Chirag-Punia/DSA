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
    public static int[][] floodFill(int[][] grid, int sr, int sc, int color) {
        int n = grid.length;
        int m = grid[0].length;
        mpp = new HashMap<>();
        int target = grid[sr][sc];
        grid[sr][sc] = color;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(sr,sc));
        mpp.put(new Pair(sr,sc),true);
        while(!q.isEmpty()){
            Pair c = q.poll();

            makeIt2(grid,c.i,c.j,n,m,q,color,target);
        }
        return grid;
    }
}