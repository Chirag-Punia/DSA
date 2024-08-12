class Solution {
    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        List<Integer> I = new ArrayList<>();
        List<Integer> J = new ArrayList<>();
        for(int i = 0;i<n;i++){
            for(int j = 0;j<m;j++){
                if(matrix[i][j] == 0){
                    I.add(i);
                    J.add(j);
                }
            }
        }
        for(int k = 0;k<J.size();k++)
            for(int i = 0;i<n;i++)
                matrix[i][J.get(k)] = 0;
        for(int k = 0;k<I.size();k++)
            for(int i = 0;i<m;i++)
                matrix[I.get(k)][i] = 0;
    }
}