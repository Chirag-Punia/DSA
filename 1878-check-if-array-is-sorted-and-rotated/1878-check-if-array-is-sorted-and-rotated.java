import java.util.*;

class Solution {
    public boolean check(int[] nums) {
        int[] arr = new int[nums.length];
        for(int i = 0; i < nums.length ; i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr);
        for(int x = 0; x< nums.length;x++){
            boolean ans = true;
            for(int i = 0; i< nums.length;i++){
            if(arr[i] != nums[(i+x) % arr.length]){
                ans = false;
                break;
            }
        }
        if(ans){
            return ans;
        }
        }
        return false;
        

    }
}