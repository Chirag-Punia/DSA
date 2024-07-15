class Solution {

    public boolean isSafe(char[][] board,int row,int col,char digit){
        //rows
        int j = 0;
        while(j < 9){
            if(board[j][col] == digit)return false;
            ++j;
        }
        j = 0;
        //coloumn
        while(j < 9){
            if(board[row][j] == digit)return false;
            ++j;
        }
        //grid
        int sr = (row/3)*3;
        int sc = (col/3)*3;
        int n = sr + 3;
        int m = sc + 3;
        while(sr < n){
            while(sc < m){
                if(board[sr][sc] == digit)return false;
                ++sc;
            }
            ++sr;
            sc = m - 3;
        }
        return true;

    }
    public boolean solve(char[][] board,int row,int col){
        if(row == 9)return true;
        int newRow = row, newCol = col+1;
        if(col+1 == 9){
            newRow = row+1;
            newCol = 0;
        }
        if(board[row][col] != '.')return solve(board,newRow,newCol);
        for(int i = 1;i<=9;i++){
            if(isSafe(board,row,col,(char)(i + '0'))){
                board[row][col] = (char)(i + '0');
                if(solve(board,newRow,newCol))return true;
                board[row][col] = '.';
            }
        }
        return false;
    }
    public void solveSudoku(char[][] board) {
        solve(board,0,0);
    }
}