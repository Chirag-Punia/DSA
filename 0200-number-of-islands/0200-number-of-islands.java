class Solution {
    class Pair{
        int nx;
        int ny;
        Pair(int nx,int ny){
            this.nx = nx;
            this.ny = ny;
        }
        @Override
        public boolean equals(Object o){
            if(this == o)return true;
            Pair pair = (Pair) o;
            return pair.nx == nx && pair.ny == ny;
        }
        @Override
        public int hashCode() {
            return Objects.hash(nx, ny);
        }
    }
    public void dfs(char[][] grid,int i,int j,Map<Pair,Boolean> mpp){
        int n = grid.length;
        int m = grid[0].length;
        int[] x = {0,-1,1,0};
        int[] y = {1,0,0,-1};
        for(int k = 0;k<4;k++){
            int nx = i + x[k];
            int ny = j + y[k];
            if(nx < n && nx >= 0 && ny >= 0 && ny < m && grid[nx][ny] == '1'
            && !mpp.getOrDefault(new Pair(nx,ny),false)){
                mpp.put(new Pair(nx,ny),true);
                dfs(grid,nx,ny,mpp);
            }
        }
    }

    public int numIslands(char[][] grid) {
        Map<Pair,Boolean> mpp = new HashMap<>();
        int cnt = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j = 0;j<grid[0].length;j++){
                if(grid[i][j] == '1' && !mpp.getOrDefault(new Pair(i,j),false)){
                    cnt++;
                    mpp.put(new Pair(i, j), true);
                    dfs(grid,i,j,mpp);
                }
            }
        }
        return cnt;
    }
}