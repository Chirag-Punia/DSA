class Solution {
    public static void reverseArray(int[] array) {
        int left = 0;
        int right = array.length - 1;

        while (left < right) {
            int temp = array[left];
            array[left] = array[right];
            array[right] = temp;

            left++;
            right--;
        }
    }
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        for(int i =0 ;i<n;i++){
            for(int j = i;j<n;j++){
                if(i != j){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
                }
                
            }
        }

        for(int i =0;i<n;i++){
            reverseArray(matrix[i]);
        }

    }
}