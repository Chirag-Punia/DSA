class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0,j=0,cnt=0,n = nums1.length,m=nums2.length,ele1 = 0,ele2 = 0;
        while(i < n && j < m){
            if(nums1[i] >= nums2[j]){
                if(cnt == ((n + m)/2 - 1)){
                    ele1 = nums2[j];
                }
                else if(cnt == ((n + m)/2)){
                    ele2 = nums2[j];
                }
                j++;
                cnt++;
            }
            else{
                if(cnt == ((n + m)/2 - 1)){
                    ele1 = nums1[i];
                }
                else if(cnt == ((n + m)/2)){
                    ele2 = nums1[i];
                }
                i++;
                cnt++;
            }
        }
        while(i < n){
            if(cnt == ((n + m)/2 - 1)){
                    ele1 = nums1[i];
                }
                else if(cnt == ((n + m)/2)){
                    ele2 = nums1[i];
                }
                i++;
                cnt++;
        }
        while(j < m){
            if(cnt == ((n + m)/2 - 1)){
                ele1 = nums2[j];
            }
            else if(cnt == ((n + m)/2)){
                ele2 = nums2[j];
            }
            j++;
            cnt++;
        }

        if((n+m) % 2 != 0)return (double)ele2;
        return (double)(((double)ele1 + (double)ele2)/ 2);
    }
}