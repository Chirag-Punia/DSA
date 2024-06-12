class Solution {

    public static int binarySearch(int[] arr,int target,int left,int right){
        int mid  = (left+right)/2;
        if(left <= right){
            if(arr[mid] == target){
            return mid;
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

        return - 1;
        

    }
    public int search(int[] nums, int target) {
        
        return binarySearch(nums,target,0,nums.length-1);

        //BRUTE FORCE
        // for(int i = 0;i<nums.length;i++){
        //     if(nums[i] == target){
        //         return i;
        //     }
        // }
        // return -1;
    }
}