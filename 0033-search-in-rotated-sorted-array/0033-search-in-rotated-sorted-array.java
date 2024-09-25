class Solution {
    public int binarySearch(int[] nums,int left,int right,int t){
        if(left > right)return -1;
        int mid = left + (right - left)/2;
        if(nums[mid] == t)return mid;
        else if(nums[mid] >= nums[left]){
            if(nums[left] <= t && nums[mid] >= t)
                return binarySearch(nums,left,mid-1,t);
            else 
                return binarySearch(nums,mid + 1,right,t);
        }
        else{
            if(nums[right] <= t && nums[mid] >= t)
                return binarySearch(nums,mid + 1,right,t);
            else
                return binarySearch(nums,left,mid-1,t);
        }     
    }
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }
}