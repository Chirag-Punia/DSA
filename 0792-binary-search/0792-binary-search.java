class Solution {

    public static int binarySearch(int[] arr , int target,int left,int right){
        int mid = (left+right)/2;
        if(left <= right){
        if(arr[mid] == target){
            return mid;
        }
        else if(arr[mid] > target){
            return binarySearch(arr,target,left,mid-1);
        }
        else{
            return binarySearch(arr,target,mid + 1,right);
        }
        }
        return -1;
    }
    public int search(int[] arr, int target) {

        return binarySearch(arr,target,0,arr.length - 1);

        //ITERATIVE BINARY SEARCH
        // int right = arr.length - 1;
        // int left = 0;
        // while(left <= right){
        // int mid = (left+right)/2;
        // if(arr[mid] == target){
        //     return mid;
        // }
        // else if(arr[mid] > target){
        //     right = mid-1;
        // }
        // else{
        //     left = mid+1;
        // }
        // }
        // return -1;
    }
}