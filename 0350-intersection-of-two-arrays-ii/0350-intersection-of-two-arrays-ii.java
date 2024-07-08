class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        HashMap<Integer, Integer> mpp = new HashMap<>();
        List<Integer> arr = new ArrayList<>();
        if (n > m) {
            for (int num : nums2)
                mpp.put(num, mpp.getOrDefault(num, 0) + 1);
            for (int num : nums1) {
                if (mpp.getOrDefault(num, 0) != 0) {
                    arr.add(num);
                    mpp.put(num, mpp.get(num) - 1);
                }
            }

        } else {
            for (int num : nums1)
                mpp.put(num, mpp.getOrDefault(num, 0) + 1);
            for (int num : nums2) {
                if (mpp.getOrDefault(num, 0) != 0) {
                    arr.add(num);
                    mpp.put(num, mpp.get(num) - 1);
                }
            }
        }

    int[] ans = new int[arr.size()];
    for(int i = 0;i<arr.size();i++)ans[i] = arr.get(i);
    return ans;

    }

}