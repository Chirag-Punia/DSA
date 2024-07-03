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
    public void dfs(char[][]b,int i,int j,int n,int m){
        int[] x = {1,-1,0,0};
        int[] y = {0,0,1,-1};
        for(int k = 0;k < 4;k++){
            Pair tmp = new Pair(i+x[k],j+y[k]);
            if(i + x[k] < n && i + x[k] >= 0 && j + y[k] >=0 && j + y[k] < m && b[i+x[k]][j + y[k]] == 'O' && !mpp.getOrDefault(tmp,false)) {
                mpp.put(tmp,true);
                dfs(b,i + x[k],j + y[k],n,m);
            }
        }
    }
    public void solve(char[][] b) {
        int n = b.length;
        int m = b[0].length;

        mpp = new HashMap<>();

        //upper Row
        for(int i = 0;i<m;i++){
            if(b[0][i] == 'O'){
                Pair tmp = new Pair(0,i);
                mpp.put(tmp,true);
                dfs(b,0,i,n,m);
            }
        }
        //bootom Row
        for(int i = 0;i<m;i++){
            if(b[n-1][i] == 'O'){
                Pair tmp = new Pair(n-1,i);
                mpp.put(tmp,true);
                dfs(b,n-1,i,n,m);
            }
        }

        //left coloumn
        for(int i = 1;i<n-1;i++){
            if(b[i][0] == 'O'){
                Pair tmp = new Pair(i,0);
                mpp.put(tmp,true);
                dfs(b,i,0,n,m);
            }
        }

        //right coloumn
        for(int i = 1;i<n-1;i++){
            if(b[i][m-1] == 'O'){
                Pair tmp = new Pair(i,m-1);
                mpp.put(tmp,true);
                dfs(b,i,m-1,n,m);
            }
        }
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++) b[i][j] = 'X';
        }
        mpp.forEach((key,value) -> {
            Pair tmp = key;
            b[tmp.i][tmp.j] = 'O';
        });
    }
}