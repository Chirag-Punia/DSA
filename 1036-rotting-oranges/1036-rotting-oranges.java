class Solution {
    public static class Pair{
        int i;
        int j;
        int min;
        Pair(int i,int j,int min){
            this.i=i;
            this.j=j;
            this.min=min;
        }
    }
    public static HashMap<Pair,Boolean> mpp = new HashMap<>();
    public static boolean ans;
    public static int minutes;
    public static int count(int[][] grid){
        int cnt1 = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 1) cnt1++;
            }
        }
        return cnt1;
    }
    public static void makeIt2(int[][] grid,int i,int j,int n,int m,int min,Queue<Pair> q){
            if(i + 1 < n && grid[i+1][j] == 1 && !mpp.getOrDefault(new Pair(i+1,j,min),false)) {grid[i+1][j] = 2;q.offer(new Pair(i+1,j,min+1));}
            if(i - 1 >= 0 && grid[i-1][j] == 1 && !mpp.getOrDefault(new Pair(i-1,j,min),false)) {grid[i-1][j] = 2;q.offer(new Pair(i-1,j,min+1));}
            if(j + 1 < m && grid[i][j+1] == 1 && !mpp.getOrDefault(new Pair(i,j+1,min),false)) {grid[i][j+1] = 2;q.offer(new Pair(i,j+1,min+1));}
            if(j - 1 >= 0 && grid[i][j-1] == 1 && !mpp.getOrDefault(new Pair(i,j-1,min),false)) {grid[i][j-1] = 2;q.offer(new Pair(i,j-1,min+1));}
    }
    // public static void gridT(int[][] grid,int n,int m){
    //     boolean changed;
    //     do {
    //         changed = false;
    //         int[][] tempGrid = new int[n][m];
    //         for (int i = 0; i < n; i++) {
    //             for (int j = 0; j < m; j++) {
    //                 tempGrid[i][j] = grid[i][j];
    //             }
    //         }

    //         for (int i = 0; i < grid.length; i++) {
    //             for (int j = 0; j < grid[i].length; j++) {
    //                 Pair tmp = new Pair(i,j);
    //                 if (grid[i][j] == 2 && !mpp.getOrDefault(tmp,false)) {
    //                     mpp.put(tmp,true);
    //                     makeIt2(tempGrid, i, j, n, m);
    //                     changed = true;
    //                 }
    //             }
    //         }

    //         for (int i = 0; i < n; i++) {
    //             for (int j = 0; j < m; j++) {
    //                 grid[i][j] = tempGrid[i][j];
    //             }
    //         }

    //         if (changed) minutes++;
    //     }while(changed);

    //     ans = count(grid) == 0;

    //     if (!ans) minutes = -1;
    // }
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;

        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 2){Pair t = new Pair(i,j,0);q.offer(t);mpp.put(t,true);}
            }
        }
        while(!q.isEmpty()){
            Pair c = q.poll();
            ans = Math.max(ans,c.min);
            makeIt2(grid,c.i,c.j,n,m,c.min,q);
        }
        if(count(grid) > 0) return -1;
        return ans;
    }
}