import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] minRow = new int[rows];
        int[] maxCol = new int[cols];
        List<Integer> ans = new ArrayList<>();


        for (int i = 0; i < rows; i++) {
            minRow[i] = Integer.MAX_VALUE;
        }


        for (int j = 0; j < cols; j++) {
            maxCol[j] = Integer.MIN_VALUE;
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                minRow[i] = Math.min(minRow[i], matrix[i][j]);
            }
        }


        for (int j = 0; j < cols; j++) {
            for (int i = 0; i < rows; i++) {
                maxCol[j] = Math.max(maxCol[j], matrix[i][j]);
            }
        }


        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == minRow[i] && matrix[i][j] == maxCol[j]) {
                    ans.add(matrix[i][j]);
                }
            }
        }

        return ans;
    }
}