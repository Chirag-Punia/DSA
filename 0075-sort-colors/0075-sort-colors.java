class Solution {
    public static void swap(int[] arr,int x , int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    public void sortColors(int[] arr) {

        //Dutch national flag
        
        int low = 0,mid = 0,high = arr.length-1;
        while(mid <= high){
            if(arr[mid] == 0){
                swap(arr,mid,low);
                low++;
                mid++;
            }
            else if(arr[mid] == 1){
                mid++;
            }
            else{
                swap(arr,mid,high);
                high--;
            }
        }




        //BRUTE FORCE
        // int zeroC = 0;
        // int oneC = 0;
        // int twoC = 0;
        // for(int i = 0; i<nums.length;i++){
        //     if(nums[i] == 0){
        //         zeroC++;
        //     }
        //     else if(nums[i] == 1){
        //         oneC++;
        //     }
        //     else{
        //         twoC++;
        //     }
        // }
        // for(int i = 0;i<zeroC;i++){
        //     nums[i] = 0;
        // }
        // for(int i = zeroC;i<zeroC+oneC;i++){
        //     nums[i] = 1;
        // }
        // for(int i = zeroC+oneC;i<zeroC+oneC+twoC;i++){
        //     nums[i] = 2;
        // }


    }
}