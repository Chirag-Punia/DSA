class Solution {
    public void moveZeroes(int[] nums) {
        ArrayList<Integer> arr = new ArrayList<>();
        int n = nums.length;
        int count = 0;
        for(int i= 0 ; i<n; i++){
            if(nums[i] != 0){
                arr.add(nums[i]);
            }
            else{
                count++;
            }
        }
        for(int i=0;i<n-count;i++){
            nums[i] = arr.get(i);
        }
        for(int i = n-count; i<n;i++){
            nums[i] = 0;
        }
    }
}