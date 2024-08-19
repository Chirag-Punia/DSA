class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // int i = m - 1;
        // int j = n - 1;
        // int k = m + n - 1;
        
        // while (j >= 0) {
        //     if (i >= 0 && nums1[i] > nums2[j]) {
        //         nums1[k] = nums1[i];
        //         k--;
        //         i--;
        //     } else {
        //         nums1[k] = nums2[j];
        //         k--;
        //         j--;
        //     }
        // }

        int i = m-1;
        int j = 0;
        while(i >= 0 && j < n){
            if(nums1[i] > nums2[j]){
                int t = nums1[i];
                nums1[i] = nums2[j];
                nums2[j] = t;
            }
            else break;
            i--;
            j++;
        }
        Arrays.sort(nums2);
        Arrays.sort(nums1,0,m);
        for(int k = 0;k<n;k++){
            nums1[m+k] = nums2[k];
        }
    }
}
