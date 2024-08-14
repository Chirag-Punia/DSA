class Solution {
    public boolean binarySearch(int[] a, int left, int right, int target) {
        if (left > right)
            return false;
        int mid = left + (right - left) / 2;
        if (a[mid] == target)
            return true;
        else if (a[mid] < target)
            return binarySearch(a, mid + 1, right, target);
        else
            return binarySearch(a, left, mid - 1, target);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int[] a : matrix)
            if(binarySearch(a, 0, a.length - 1, target))return true;
        return false;
    }
}