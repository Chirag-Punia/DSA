import java.util.HashMap;

class Solution {
    public int maxEqualRowsAfterFlips(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        HashMap<String, Integer> patternCount = new HashMap<>();

        for (int[] row : matrix) {
            StringBuilder normal = new StringBuilder();
            StringBuilder flipped = new StringBuilder();

            for (int val : row) {
                normal.append(val);
                flipped.append(1 - val);
            }

            String normalPattern = normal.toString();
            String flippedPattern = flipped.toString();
            patternCount.put(normalPattern, patternCount.getOrDefault(normalPattern, 0) + 1);
            patternCount.put(flippedPattern, patternCount.getOrDefault(flippedPattern, 0) + 1);
        }

        int maxRows = 0;
        for (int count : patternCount.values()) {
            maxRows = Math.max(maxRows, count);
        }

        return maxRows;
    }
}
