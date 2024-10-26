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
        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Pair pair = (Pair) o;
            return i == pair.i && j == pair.j && min == pair.min;
        }

        @Override
        public int hashCode() {
            return Objects.hash(i, j, min);
        }
    }
    public static int cnt2 = 0;
    public static HashMap<Pair,Boolean> mpp = new HashMap<>();
    // public static boolean ans;
    // public static int minutes;
    // public static int count(int[][] grid){
    //     int cnt1 = 0;
    //     for(int i = 0;i<grid.length;i++){
    //         for(int j=0;j<grid[i].length;j++){
    //             if(grid[i][j] == 1) cnt1++;
    //         }
    //     }
    //     return cnt1;
    // }
    
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

    public static void makeIt2(int[][] grid,int i,int j,int n,int m,int min,Queue<Pair> q){
            if(i + 1 < n && grid[i+1][j] == 1 && !mpp.getOrDefault(new Pair(i+1,j,min),false)) {grid[i+1][j] = 2;q.offer(new Pair(i+1,j,min+1));++cnt2;mpp.put(new Pair(i+1,j,min+1),true);}
            if(i - 1 >= 0 && grid[i-1][j] == 1 && !mpp.getOrDefault(new Pair(i-1,j,min),false)) {grid[i-1][j] = 2;q.offer(new Pair(i-1,j,min+1));++cnt2;mpp.put(new Pair(i-1,j,min+1),true);}
            if(j + 1 < m && grid[i][j+1] == 1 && !mpp.getOrDefault(new Pair(i,j+1,min),false)) {grid[i][j+1] = 2;q.offer(new Pair(i,j+1,min+1));++cnt2;mpp.put(new Pair(i,j+1,min+1),true);}
            if(j - 1 >= 0 && grid[i][j-1] == 1 && !mpp.getOrDefault(new Pair(i,j-1,min),false)) {grid[i][j-1] = 2;q.offer(new Pair(i,j-1,min+1));++cnt2;mpp.put(new Pair(i,j-1,min+1),true);}
    }
    public int orangesRotting(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int cnt1 = 0;
        cnt2 = 0;
        mpp = new HashMap<>();

        Queue<Pair> q = new LinkedList<>();
        int ans = 0;
        for(int i = 0;i<grid.length;i++){
            for(int j=0;j<grid[i].length;j++){
                if(grid[i][j] == 2){Pair t = new Pair(i,j,0);q.offer(t);mpp.put(t,true);}
                if(grid[i][j] == 1)cnt1++;
            }
        }
        while(!q.isEmpty()){
            Pair c = q.poll();
            ans = Math.max(ans,c.min);
            makeIt2(grid,c.i,c.j,n,m,c.min,q);
        }
        if(cnt1 != cnt2) return -1;
        return ans;
    }
}