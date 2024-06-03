class Solution {

    public static void reverse(int[] arr, int i, int j){
        while(i <= j){
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i++;
            j--;
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums,0,nums.length - k - 1);
        reverse(nums,nums.length - k,nums.length-1);
        reverse(nums,0,nums.length-1);
        


    //     BRUTE FORCE
    //     for(int j= 0; j < k ; j++){
    //     int temp = nums[nums.length-1];
    //     for(int i = nums.length-1; i>0;i--){
    //         nums[i] = nums[i-1];

    //     }
    //     nums[0] = temp;
    //     }
     }
}