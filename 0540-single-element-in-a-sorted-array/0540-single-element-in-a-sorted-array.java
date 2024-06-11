class Solution {
    public static int binarySearch(int[] arr, int left, int right) {
        int mid = (left + right) / 2;

        if (arr[mid] != arr[mid + 1] && arr[mid] != arr[mid - 1]) {
            return arr[mid];
        } else if (mid % 2 == 0) {
            if (arr[mid] == arr[mid + 1]) {
                return binarySearch(arr, mid, right);
            } else {
                return binarySearch(arr, left, mid);
            }

        } else {
            if (arr[mid] == arr[mid - 1]) {
                return binarySearch(arr, mid, right);
            } else {
                return binarySearch(arr, left, mid);
            }
        }
    }

    public int singleNonDuplicate(int[] arr) {

        if (arr.length == 1) {
            return arr[0];
        } else if (arr[arr.length - 1] != arr[arr.length - 2]) {
            return arr[arr.length - 1];
        } else if (arr[0] != arr[1]) {
            return arr[0];
        }
        return binarySearch(arr, 0, arr.length - 1);

        // BRUTE FORCCE
        // int ans = 0;
        // for(int i = 0 ;i<nums.length;i++){
        // ans = nums[i] ^ ans;
        // }
        // return ans;

    }
}