class Solution {
    public void moveZeroes(int[] nums) {
        int j = -1;
        int n = nums.length;
        for(int k = 0; k < n; k++){
            if(nums[k] == 0){
                j = k;
                break;
            }
        }
        if(j != -1){
            for(int i = j;i<n;i++){
            if(nums[i] != 0){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                // j will always point to zero as after swap next element will always be zero
                j++;
            }
        }
        }
        

     

       




        //BRUTE FORCE
    //     ArrayList<Integer> arr = new ArrayList<>();
    //     int n = nums.length;
    //     int count = 0;
    //     for(int i= 0 ; i<n; i++){
    //         if(nums[i] != 0){
    //             arr.add(nums[i]);
    //         }
    //         else{
    //             count++;
    //         }
    //     }
    //     for(int i=0;i<n-count;i++){
    //         nums[i] = arr.get(i);
    //     }
    //     for(int i = n-count; i<n;i++){
    //         nums[i] = 0;
    //     }


    }
}