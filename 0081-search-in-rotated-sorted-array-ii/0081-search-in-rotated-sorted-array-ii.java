class Solution {
    public static boolean binarySearch(int[] arr,int target,int left,int right){
        int mid  = (left+right)/2;
        if(left <= right){
        if(arr[mid] == target){
            return true;
        }
        if(arr[left] == arr[mid] && arr[right] == arr[mid]){
                return binarySearch(arr,target,left+1,right-1);
            }
        else if(arr[left] <= arr[mid]){
            if(arr[left] <= target && target <= arr[mid]){
                return binarySearch(arr,target,left,mid-1);
            }
            else{
                return binarySearch(arr,target,mid + 1,right);
            }
        }
        else{
            if(target <= arr[right] && target >= arr[mid]){
                return binarySearch(arr,target,mid + 1,right);
            }
            else{
                return binarySearch(arr,target,left,mid-1);
            }
        }
        }

        return false;
        

    }

    public boolean search(int[] nums, int target) {
        return binarySearch(nums, target, 0, nums.length - 1);
    }
}