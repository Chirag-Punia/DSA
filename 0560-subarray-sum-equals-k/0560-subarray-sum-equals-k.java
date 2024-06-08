class Solution {

    public int subarraySum(int[] nums, int k) {

        HashMap<Integer,Integer> mpp = new HashMap<>();
        int sum = 0,count = 0;
        for(int i = 0;i<nums.length;i++){
            sum = sum + nums[i];
            int rem = sum - k;
            if(sum == k){
                count++;
            }
            if(mpp.containsKey(rem)){
                count = count + mpp.get(rem);
            }

            mpp.put(sum,mpp.getOrDefault(sum,0) + 1);

        }     
        return count;










    //     int left = 0,right = 0,sum = nums[0],count = 0;
    //     while(left < nums.length){
            
    //         while(sum > k){
    //             sum = sum - nums[left];
    //             left++;
    //         } 
    //         if(sum < k){
    //             sum = sum + nums[right];
    //             right++;
    //         }
    //         if(sum == k){
    //             count++;
    //             right++;
    //         }

    //     }

    // return count;








        //BRUTE FORCE
        // int sum = 0,count = 0;
        // for(int i =0;i<nums.length;i++){
        //     for(int j = i;j<nums.length;j++){
        //         sum = sum + nums[j];
        //         if(sum == k){
        //             count++;
        //         }
                
        //     }
        //     sum = 0;
        // }
        // return count;
    }
}