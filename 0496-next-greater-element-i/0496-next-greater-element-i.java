class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {


        //OPTIMAL
        int[] ans = new int[nums2.length];
        int[] ans2 = new int[nums1.length];
        Stack<Integer> s = new Stack<>();
        for(int i = nums2.length - 1;i>=0;i--){
            int curr = nums2[i];
            while(!s.isEmpty() && curr >= nums2[s.peek()]){
                s.pop();
            }
            if(s.isEmpty()){
                ans[i] = -1;
            }
            else{
                ans[i] = nums2[s.peek()];
            }
            s.push(i);
        }
        for(int i = 0;i<nums1.length;i++){
            int curr = nums1[i];
            for(int j = 0; j<nums2.length;j++){
                if(curr == nums2[j]){
                    ans2[i] = ans[j];
                }
            }
        }
        return ans2;



        //BRUTE FORCE
        // int[] ans = new int[nums1.length];
        // Stack<Integer> s = new Stack<>();
        // for(int i = 0;i<nums1.length;i++){
        //     int curr = nums1[i];
        //     boolean isFound = false;
        //     for(int j = 0;j<nums2.length;j++){
        //         if(nums2[j] == curr) isFound = true;
        //         if(nums2[j] > curr && isFound){
        //             ans[i] = nums2[j];
        //             break;
        //         }
        //         else{
        //             ans[i] = -1;
        //         }

        //     }
        // }
        // return ans;

    }
}