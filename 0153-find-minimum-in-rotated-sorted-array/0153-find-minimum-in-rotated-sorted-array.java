class Solution {
    public static int binarySearch(int[] arr,int x,int left,int right,int ans){
        int mid  = (left+right)/2;
        ans = Math.min(ans,x);
        if(left <= right){
            if(arr[mid] > arr[right]){
                return binarySearch(arr,arr[left],mid+1,right,ans);
            }
            else{
                return binarySearch(arr,arr[mid],left,mid-1,ans);
            }
        }
        return ans;
    }
    public int findMin(int[] nums) {
        return binarySearch(nums,Integer.MAX_VALUE,0,nums.length-1,Integer.MAX_VALUE);
    }
}