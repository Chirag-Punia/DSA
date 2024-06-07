class Solution {


    public static int temp(int[] nums,int i,int sum,int maxSum){
        int ans = maxSum;
        if(i >= nums.length){
            return ans;
        }
        for(int j = i;j<nums.length;j++){
            sum = sum + nums[j];
            if(sum > maxSum){
            maxSum = sum;
        }
        }
        
        return temp(nums,++i,0,maxSum);
        
    }
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i = 0; i< nums.length;i++){
            sum = sum + nums[i];
            if (sum > maxi){
                maxi = sum;
            }
            if(sum < 0){
                sum = 0;
            }
        }
        return maxi;




        // int sum = 0;
        // int maxSum = Integer.MIN_VALUE;
        // for(int i = 0;i<nums.length;i++){
        //     sum = 0;
        //     for(int j = i ; j <nums.length;j++){
        //         sum = sum + nums[j];
        //         if(sum > maxSum){
        //             maxSum = sum;
        //         }
        //     }
        // }
        // return maxSum;
    }
}