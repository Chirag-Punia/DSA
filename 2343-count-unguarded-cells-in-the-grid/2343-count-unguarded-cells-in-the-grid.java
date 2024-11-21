class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] mat = new int[m][n]; 


        for (int[] r : guards) {
            mat[r[0]][r[1]] = -1;
        }
        for (int[] r : walls) {
            mat[r[0]][r[1]] = 1;
        }


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == -1) {

                    for (int k = i + 1; k < m; k++) {
                        if (mat[k][j] == 1 || mat[k][j] == -1) break;
                        mat[k][j] = -2;
                    }

                    for (int k = i - 1; k >= 0; k--) {
                        if (mat[k][j] == 1 || mat[k][j] == -1) break;
                        mat[k][j] = -2;
                    }

                    for (int k = j + 1; k < n; k++) {
                        if (mat[i][k] == 1 || mat[i][k] == -1) break;
                        mat[i][k] = -2;
                    }

                    for (int k = j - 1; k >= 0; k--) {
                        if (mat[i][k] == 1 || mat[i][k] == -1) break;
                        mat[i][k] = -2;
                    }
                }
            }
        }

 
        int cnt = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) cnt++;
            }
        }
        return cnt;
    }
}
