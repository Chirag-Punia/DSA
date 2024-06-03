import java.util.*;

class Solution {
    public boolean check(int[] nums) {

        int count = 0;
        int length = nums.length;
        for(int i = 0; i < length-1;i++){
            if(nums[i] > nums[i+1]){
                //violation count
                count++;
            }
        }
        //circular violation count
        if(nums[0] < nums[length-1]) count++;

        return count <= 1;















        //TOOO SLOOWWWW
        // int[] arr = new int[nums.length];
        // for(int i = 0; i < nums.length ; i++){
        //     arr[i] = nums[i];
        // }
        // Arrays.sort(arr);
        // for(int x = 0; x< nums.length;x++){
        //     boolean ans = true;
        //     for(int i = 0; i< nums.length;i++){
        //     if(arr[i] != nums[(i+x) % arr.length]){
        //         ans = false;
        //         break;
        //     }
        // }
        // if(ans){
        //     return ans;
        // }
        // }
        // return false;
        

    }
}