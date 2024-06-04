class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int sum = ((n)*(n+1))/(2);
        int temp = 0;
        for(int i = 0; i< n ;i++){
            temp = temp + nums[i];
        }
        return sum-temp;








        //BRUTE FORCE
        // int[] arr =new int[nums.length+1];
        
        // for(int i = 0 ; i< nums.length ; i++){
        //     arr[nums[i]]++;
        // }
        // for(int i = 0; i< nums.length+1;i++){
        //     if(arr[i] == 0){
        //         return i;
        //     }
        // }
        // return -1;
        
    }
}