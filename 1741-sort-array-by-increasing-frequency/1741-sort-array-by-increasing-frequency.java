import java.util.*;

class Solution {
    public int[] frequencySort(int[] nums) {

        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for (int num : nums) {
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }
        
        
        List<Map.Entry<Integer, Integer>> entries = new ArrayList<>(frequencyMap.entrySet());
        entries.sort((e1, e2) -> {
            int freqCompare = Integer.compare(e1.getValue(), e2.getValue());
            if (freqCompare != 0) {
                return freqCompare; 
            }
            return Integer.compare(e2.getKey(), e1.getKey()); 
        });
        
       
        int index = 0;
        int[] result = new int[nums.length];
        for (Map.Entry<Integer, Integer> entry : entries) {
            int value = entry.getKey();
            int count = entry.getValue();
            for (int i = 0; i < count; i++) {
                result[index++] = value;
            }
        }
        
        return result;
    }
}