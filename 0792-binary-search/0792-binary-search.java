class Solution {
    public int search(int[] arr, int target) {
        int right = arr.length - 1;
        int left = 0;
        while(left <= right){
        int mid = (left+right)/2;
        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] > target){
            right = mid-1;
        }
        else{
            left = mid+1;
        }
        }
        return -1;
    }
}