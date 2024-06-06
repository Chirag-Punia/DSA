class Solution {
    public int searchInsert(int[] arr, int target) {
        
        int left = 0;
        int right = arr.length - 1;

        //Here LEFT point to largest number less than TARGET

        while(left <= right){
            int mid = (left+right)/2;
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                right = mid - 1;
            }
            else{
                left = mid + 1;
            }
        }
        return left;
    }
}