class Solution {
    public static boolean isPresent(int[] arr,int i){
        boolean x = false;
        for(int j = 0;j<arr.length;j++){
                if(i == arr[j]){
                    x = true;
                    break;
                }
            }
        return x;
    }

    public int findKthPositive(int[] arr, int k) {

        //BRUTE FORCE
        for(int i = 0; i < arr.length;i++){
            if(arr[i] <= k){
                k++;
            }
            else{
                break;
            }
        }
        return k;




        //JAMA HI BRUTE FORCE
        // int temp = 0;
        // int max = Integer.MIN_VALUE;
        // for(int i= 0;i<arr.length;i++){
        //     max = Math.max(max,arr[i]);
        // }
        // for(int i = 1; i<=max+k;i++){
        //     boolean x = false;
        //     for(int j = 0;j<arr.length;j++){
        //         if(i == arr[j]){
        //             x = true;
        //             break;
        //         }
        //     }
        //     if(!x){
        //         temp++;
        //         if(temp == k){
        //             return i;
        //         }
        //     }
        // }
        // return -1;
    }
}