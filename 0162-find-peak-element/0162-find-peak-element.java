class Solution {
    public int findPeakElement(int[] arr) {

        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
                return i;
            }
        }
        if (arr.length > 1) {
            if (arr[0] > arr[1]) {
                return 0;
            } else if (arr[arr.length - 1] > arr[arr.length - 2]) {
                return arr.length - 1;
            }
        } else {
            return 0;
        }

        return 0;
    }
}