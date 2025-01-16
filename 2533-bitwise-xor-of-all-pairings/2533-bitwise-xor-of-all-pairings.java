class Solution {
    public int xorAllNums(int[] nums1, int[] nums2) {
        int ans = 0;
        int n1 = nums1.length;
        int n2 = nums2.length;
        for(int a : nums1){
            if(n2 % 2 != 0)
                ans = ans ^ a;
        }
        for(int b : nums2){
            if(n1 % 2 != 0)
                ans = ans ^ b;
        }
        return ans;
    }
}