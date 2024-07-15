class Solution {
    public HashMap<Character,Boolean> mpp;
    public boolean ans;
    public int[] x = { 1, -1, 0, 0 };
    public int[] y = { 0, 0, 1, -1 };
    public void dfs(char[][] board,String word,int i,int j,int f,int n,int m){
        if(f == word.length()){
            ans=true;
            return;
        }
        char temp = board[i][j];
        board[i][j] = '#';
        for (int k = 0; k < 4; k++) {
            int newx = i + x[k];
            int newy = j + y[k];
            if (!ans && newx < n && newx >= 0 && newy >= 0 && newy < m && board[newx][newy] == word.charAt(f)){
                dfs(board,word,newx,newy,f+1,n,m);
            }
        }
        board[i][j] = temp;
    }
    public boolean exist(char[][] board, String word) {
        mpp = new HashMap<>();
        ans = false;
        int n = board.length;
        int m = board[0].length;
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(board[i][j] == word.charAt(0)){
                    dfs(board,word,i,j,1,n,m);
                    if(ans)return true;
                }
            }
        }
        return ans;
    }
}