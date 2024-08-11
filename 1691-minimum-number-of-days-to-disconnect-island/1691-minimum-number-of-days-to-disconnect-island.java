class Solution {
    public int minDays(int[][] grid) {

        if(noOfIslands(grid) != 1) return 0;

        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0;
                    if(noOfIslands(grid) != 1) return 1;
                    grid[i][j] = 1;
                }
            }
        }

        return 2;
    }


    public int noOfIslands(int grid[][]){
        int islandCount = 0;
        int[][] isVisited = new int[grid.length][grid[0].length];
        int[][] directions = {{0,1},{1,0},{-1,0},{0,-1}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(isVisited[i][j] != 1 && grid[i][j] == 1){
                    dfs(grid,i,j,isVisited,directions);
                    islandCount++;
                }
            }
        }
        return islandCount;
    }

    public void dfs(int[][] grid,int row,int col,int[][] isVisited,int[][] directions){
        if(row < 0 || col < 0 || col >= grid[0].length || row >= grid.length){
            return;
        }

        for(int[] direction : directions){
            int r = row +  direction[0];
            int c = col + direction[1];
            if(r >=0 && c>=0 && r<grid.length && c < grid[0].length && isVisited[r][c] != 1 && grid[r][c] == 1){
                isVisited[r][c] = 1;
                dfs(grid,r,c,isVisited,directions);
            }
        }
    }
}