// class Solution {
//     public int maxProduct(int[] nums) {
//         long ans = Long.MIN_VALUE;
//         for(int i = 0;i<nums.length;i++){     
//             long prod = nums[i];
//             ans = Math.max(ans,prod);
//             for(int j = i + 1;j<nums.length;j++){
//                 prod = prod * nums[j];
//                 if (prod > Integer.MAX_VALUE || prod < Integer.MIN_VALUE) {
//                     break;
//                 }
//                 ans = Math.max(ans,prod);
//             }
//         }
//         return (int)ans;
//     }

// }

class Solution {
    public int maxProduct(int[] nums) {
        double suffix = 1, prefix = 1;
        int maxi = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (suffix == 0)
                suffix = 1;
            if (prefix == 0)
                prefix = 1;
            prefix *= (double) nums[i];
            suffix *= (double) nums[nums.length - i - 1];
            maxi = (int) Math.max(maxi, Math.max(prefix, suffix));
        }
        return maxi;
    }

}