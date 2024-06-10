class Solution {

    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int col0 = 1;
        int row0 = 1;
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                row0 = 0;
                break;
            }
        }
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                col0 = 0;
                break;
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) {
                    matrix[i][j] = 0;
                }
            }
        }
        for (int i = 1; i < n; i++) {
            if (matrix[0][i] == 0) {
                for (int j = 1; j < m; j++) {
                    matrix[j][i] = 0;
                }
            }
        }
        if(matrix[0][0] == 0){
            for (int i = 0; i < n; i++) {

                matrix[0][i] = 0;

            }
            for (int i = 0; i < m; i++) {

                matrix[i][0] = 0;

            }
        }
        if (row0 == 0) {
            for (int i = 0; i < n; i++) {

                matrix[0][i] = 0;

            }
        }
        if (col0 == 0) {
            for (int i = 0; i < m; i++) {

                matrix[i][0] = 0;

            }
        }


        // ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        // ArrayList<Integer> temp = new ArrayList<>();
        // for(int i = 0;i<m;i++){
        // for(int j = 0;j<n;j++){
        // temp.add(matrix[i][j]);
        // }
        // arr.add(temp);
        // temp = new ArrayList<>();
        // }

        // for(int row = 0;row<m;row++){
        // for(int col = 0;col<n;col++){
        // if(matrix[row][col] == 0){
        // for(int i = 0;i<m;i++){
        // arr.get(i).set(col,0);
        // }
        // for(int i = 0;i<n;i++){
        // arr.get(row).set(i,0);
        // }
        // }
        // }
        // }

        // for(int i = 0;i<m;i++){
        // for(int j = 0;j<n;j++){
        // matrix[i][j] = arr.get(i).get(j);
        // }
        // }

    }
}