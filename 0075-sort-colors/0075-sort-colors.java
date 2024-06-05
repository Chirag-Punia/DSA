class Solution {
    public void sortColors(int[] nums) {
        int zeroC = 0;
        int oneC = 0;
        int twoC = 0;
        for(int i = 0; i<nums.length;i++){
            if(nums[i] == 0){
                zeroC++;
            }
            else if(nums[i] == 1){
                oneC++;
            }
            else{
                twoC++;
            }
        }
        for(int i = 0;i<zeroC;i++){
            nums[i] = 0;
        }
        for(int i = zeroC;i<zeroC+oneC;i++){
            nums[i] = 1;
        }
        for(int i = zeroC+oneC;i<zeroC+oneC+twoC;i++){
            nums[i] = 2;
        }
    }
}