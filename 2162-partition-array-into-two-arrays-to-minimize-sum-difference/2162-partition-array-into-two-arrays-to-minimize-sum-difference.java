import java.util.*;
class Solution {
    // -9 -2 -1 1 2 3 4 8
    // [-9 1 2 ] [-2 -1 ]

    public int minimumDifference(int[] nums) {
        int n = nums.length;
        if (n == 2) {
            return Math.abs(nums[0] - nums[1]);
        }
        int total = Arrays.stream(nums).sum();
        Map<Integer, List<Integer>> allSubsetSum = getSubsetSum(nums, 0, nums.length / 2);
        Map<Integer, List<Integer>> allSubsetSum1 = getSubsetSum(nums, nums.length / 2, nums.length);
        //
        int ans = Integer.MAX_VALUE;
// join the subset sum
        for (int d = 0; d <= n / 2; d++) {
            List<Integer> first = allSubsetSum.getOrDefault(d, Collections.emptyList());
            List<Integer> second = allSubsetSum1.getOrDefault(n / 2 - d, Collections.emptyList());
            int i1 = 0, i2 = second.size()  - 1;
            while (i1 < first.size() && i2 >= 0) {
                int diff = total - 2 * (first.get(i1) + second.get(i2));
                ans = Math.min(ans, Math.abs(diff));
                if (diff <= 0) {
                    i2--;
                } else {
                    i1++;
                }
            }
        }
        return ans;
    }
// compute the subset sum of each half
    private Map<Integer, List<Integer>> getSubsetSum(int[] nums, int from, int length) {
        int[] first = Arrays.copyOfRange(nums, from, length);
        return getAllSubsetSum(first);
    }

    public record Count (int sum, int setBit) {}
    private Map<Integer, List<Integer>> getAllSubsetSum(int[] nums) {
        int mask = 1 << nums.length;
        var map = new HashMap<Integer, List<Integer>>();
        for (int i = 1; i < mask; i++) {
            Count sumSubset = getSumOfSubset(nums, i);
            map.computeIfAbsent(sumSubset.setBit(), k -> new ArrayList<>()).add(sumSubset.sum());
        }
        map.put(0, new ArrayList<>(List.of(0)));
        map.forEach((key, val) -> Collections.sort(val));
        return map;
    }

    // mask = 5  (101)
    private Count getSumOfSubset(int[] nums, int mask) {
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (((mask >> i) & 1) == 1) {
                sum += nums[i];
            }
        }
        return new Count(sum, Integer.bitCount(mask));
    }

}