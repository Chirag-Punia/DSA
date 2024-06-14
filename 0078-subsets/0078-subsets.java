import java.util.ArrayList;
class Solution {
    public List<List<Integer>> subsets(int[] nums) {

        List<List<Integer>> arrMain = new ArrayList<>();
        int n = 1 << nums.length;
        for(int i = 0;i<n;i++){
            int count = -1;
            int j = i;
            List<Integer> arr = new ArrayList<>();
            while(j > 0){
                count++;
                if((j & 1) == 1){
                    arr.add(nums[count]);
                }
                
                j >>= 1;
            }
            arrMain.add(arr);
        }
        return arrMain;
    }
}