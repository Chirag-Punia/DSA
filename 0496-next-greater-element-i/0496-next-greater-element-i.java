class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        for(int i = 0;i<nums1.length;i++){
            int curr = nums1[i];
            boolean isFound = false;
            for(int j = 0;j<nums2.length;j++){
                if(nums2[j] == curr) isFound = true;
                if(nums2[j] > curr && isFound){
                    ans[i] = nums2[j];
                    break;
                }
                else{
                    ans[i] = -1;
                }

            }
        }
        return ans;

    }
}