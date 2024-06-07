class Solution {
    public static int search(int[] arr , int target,int left,int right){
        int mid = (left+right)/2;
        if(left <= right){
            if(arr[mid] == target){
                return mid;
            }
            else if(arr[mid] > target){
                return search(arr,target,left,mid-1);
            }
            else{
                return search(arr,target,mid + 1,right);
            }
        }
        return -1;
        
    }
    public int[] searchRange(int[] arr, int target) {
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 0;i<arr.length;i++){
            if(arr[i] == target){
                ans.add(i);
            }
        }
        int[] temp = new int[2];
        if(ans.size() > 1){
            temp[0] = ans.get(0);
            temp[1] = ans.get(ans.size() - 1);
        }
        else if(ans.size() == 1){
            temp[0] = ans.get(0);
            temp[1] = ans.get(0);
        }
        else{
            temp[0] = -1;
            temp[1] = -1;
        }

    return temp;
        
    }
}