class Solution {
    public boolean isValidSudoku(char[][] board) {
        return valid(board,0);
    }
    public boolean valid(char[][] board,int position){
        if(position>=81){
            return true;
        }
        int row = position / 9;
        int col = position % 9;
        if(board[row][col]=='.'){
            return valid(board,position+1);
        }
        if(isValid(board,row,col,board[row][col])){
            return valid(board,position+1);
        }
       return false;
        
    }
   public boolean isValid(char[][] board, int row, int col, char num) {
        for (int i = 0; i < 9; i++) {
            if (i != col && board[row][i] == num) {
                return false;
            }
            if (i != row && board[i][col] == num) {
                return false;
            }
        }
        
        int subRowStart = (row / 3) * 3;
        int subColStart = (col / 3) * 3;
        for (int i = subRowStart; i < subRowStart + 3; i++) {
            for (int j = subColStart; j < subColStart + 3; j++) {
                if ((i != row || j != col) && board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }
}