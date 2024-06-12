class Solution {
    public static int binarySearch(int[] arr, int left, int right) {

        int mid = (right + left) / 2;
        if (left <= right) {
            if (arr[mid] >= arr[mid + 1] && arr[mid - 1] <= arr[mid]) {
                return mid;
            } else if (arr[mid] < arr[mid + 1] && arr[mid - 1] < arr[mid]) {
                return binarySearch(arr, mid + 1, right);
            } else if (arr[mid - 1] > arr[mid] && arr[mid + 1] < arr[mid]) {
                return binarySearch(arr, left, mid - 1);
            }
            //FUNNY KISSI BHI TARAF BHEJDO
            else{
                return binarySearch(arr, left, mid - 1);
            }
        }
        return mid;
    }

    public int findPeakElement(int[] arr) {
        if (arr.length > 1) {
            if (arr[0] > arr[1]) {
                return 0;
            } else if (arr[arr.length - 1] > arr[arr.length - 2]) {
                return arr.length - 1;
            }
        } else {
            return 0;
        }

        return binarySearch(arr, 1, arr.length - 2);
        // BRUTE FORCE
        // for (int i = 1; i < arr.length - 1; i++) {
        // if (arr[i] > arr[i + 1] && arr[i] > arr[i - 1]) {
        // return i;
        // }
        // }

        // return 0;
    }
}