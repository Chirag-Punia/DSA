class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        for(int[] a : matrix)
            for(int b : a)if(b == target)return true;
        return false;
    }
}