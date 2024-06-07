class Solution {
    public static int search(int[] arr , int target,int left,int right ,boolean leftSearch,int ans){
        int mid = (left+right)/2;
        int x = ans;
        if(left <= right){
            if(arr[mid] == target){
                if(leftSearch){
                    return search(arr,target,left,mid - 1,leftSearch,mid);
                }
                else{
                    return search(arr,target,mid+1,right,leftSearch,mid);
                }
            }
            else if(arr[mid] > target){
                return search(arr,target,left,mid-1,leftSearch,ans);
            }
            else{
                return search(arr,target,mid + 1,right,leftSearch,ans);
            }
        }
        return x;
        
    }
    public int[] searchRange(int[] arr, int target) {

    int left = search(arr,target,0,arr.length-1,true,-1);
    int right = search(arr,target,0,arr.length-1,false,-1);

    int[] nums = {left,right};

    return nums;









        //BRUTE FORCE
    //     ArrayList<Integer> ans = new ArrayList<>();
    //     for(int i = 0;i<arr.length;i++){
    //         if(arr[i] == target){
    //             ans.add(i);
    //         }
    //     }
    //     int[] temp = new int[2];
    //     if(ans.size() > 1){
    //         temp[0] = ans.get(0);
    //         temp[1] = ans.get(ans.size() - 1);
    //     }
    //     else if(ans.size() == 1){
    //         temp[0] = ans.get(0);
    //         temp[1] = ans.get(0);
    //     }
    //     else{
    //         temp[0] = -1;
    //         temp[1] = -1;
    //     }

    // return temp;
        
    }
}