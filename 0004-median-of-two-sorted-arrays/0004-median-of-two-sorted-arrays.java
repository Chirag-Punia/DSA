class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Double> arr = new ArrayList<>();
        int n = nums1.length,m = nums2.length;
        for(int i : nums1)
            arr.add((double)i);
        for(int i : nums2)
            arr.add((double)i);
        Collections.sort(arr);
        if(arr.size() % 2 == 0)
            return (arr.get((n+m) / 2) + arr.get(((n+m) / 2) - 1))/2;
        return arr.get((n+m) / 2);
    }
}