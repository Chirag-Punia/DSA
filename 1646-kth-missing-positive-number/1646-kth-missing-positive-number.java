class Solution {
    public static boolean isPresent(int[] arr, int i) {
        boolean x = false;
        for (int j = 0; j < arr.length; j++) {
            if (i == arr[j]) {
                x = true;
                break;
            }
        }
        return x;
    }

    public static int binarySearch(int[] arr, int k, int left, int right, int ansIndex,int ans) {
        int mid = (left + right) / 2;
        int xx = ansIndex;
        int x = ans;
        int temp = arr[xx] + k - x;
        if (left <= right) {
            int val = arr[mid] - (mid + 1);
            if(val < k){
                return binarySearch(arr,k,mid+1,right,mid,val);
            }
            else{
                return binarySearch(arr,k,left,mid - 1,xx,x);
                
            }
        }
        return temp;
    }

    public int findKthPositive(int[] arr, int k) {

        return binarySearch(arr,k,0,arr.length-1,0,arr[0]);
        // BRUTE FORCE
        // for(int i = 0; i < arr.length;i++){
        // if(arr[i] <= k){
        // //This arr[i] is present so possible missing element will be more than K
        // k++;
        // }
        // else{
        // break;
        // }
        // }
        // return k;

        // JAMA HI BRUTE FORCE
        // int temp = 0;
        // int max = Integer.MIN_VALUE;
        // for(int i= 0;i<arr.length;i++){
        // max = Math.max(max,arr[i]);
        // }
        // for(int i = 1; i<=max+k;i++){
        // boolean x = false;
        // for(int j = 0;j<arr.length;j++){
        // if(i == arr[j]){
        // x = true;
        // break;
        // }
        // }
        // if(!x){
        // temp++;
        // if(temp == k){
        // return i;
        // }
        // }
        // }
        // return -1;
    }
}