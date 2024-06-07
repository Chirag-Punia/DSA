class Solution {
    public int majorityElement(int[] arr) {
        int count = 0;
        int ans = 0;
        for(int i = 0; i<arr.length;i++){

            if(count == 0){
                ans = arr[i];
                count = 1;
            }
            else if(ans == arr[i]){
                count++;
            }
            else{
                count--;
            }
            
            
        }
        return ans;






        //BRUTE FORCE
        // HashMap<Integer,Integer> mpp = new HashMap<>();
        // for(int i = 0;i<nums.length;i++){
        //     mpp.put(nums[i],mpp.getOrDefault(nums[i],0) + 1);
        // }
        // int[] temp = new int[1];
        // mpp.forEach((key,value) -> {
        //     if(value > (nums.length/2)){
        //         temp[0] = key;
        //     }
        // });
        // return temp[0];
    }
}