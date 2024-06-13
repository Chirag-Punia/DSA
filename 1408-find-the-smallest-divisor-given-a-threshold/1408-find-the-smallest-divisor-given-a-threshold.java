class Solution {
    public static int binarySearch(int[] nums, int threshold, int left, int right, int ans) {
        int mid = (left + right) / 2;
        int xx = ans;
        if (left <= right) {
            if(value(nums,mid) <= threshold){
                return binarySearch(nums,threshold,left,mid-1,mid);
            }
            else{
                return binarySearch(nums,threshold,mid + 1,right,xx);
            }
        }
        return xx;
    }

    public static double value(int[] nums, int i) {
        double sum = 0;
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            double val = (double) Math.ceil((double) nums[j] / (double) i);
            sum = sum + val;
        }
        return sum;
    }

    public int smallestDivisor(int[] nums, int threshold) {

        int n = nums.length;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, nums[i]);
        }
        return binarySearch(nums,threshold,1,max,-1);
    }
}