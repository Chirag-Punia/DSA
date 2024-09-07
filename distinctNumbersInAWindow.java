import java.util.*;
//https://www.interviewbit.com/problems/distinct-numbers-in-window/
public class Solution {
    public ArrayList<Integer> dNums(ArrayList<Integer> A, int B) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (B > A.size() || B == 0) {
            return ans;
        }

        Map<Integer, Integer> freqMap = new HashMap<>();
        int windowStart = 0;

        for (int windowEnd = 0; windowEnd < B; windowEnd++) {
            int element = A.get(windowEnd);
            freqMap.put(element, freqMap.getOrDefault(element, 0) + 1);
        }
        ans.add(freqMap.size());

        for (int windowEnd = B; windowEnd < A.size(); windowEnd++) {
            int elementToRemove = A.get(windowStart);
            freqMap.put(elementToRemove, freqMap.get(elementToRemove) - 1);
            if (freqMap.get(elementToRemove) == 0) {
                freqMap.remove(elementToRemove);
            }
            windowStart++;

            int elementToAdd = A.get(windowEnd);
            freqMap.put(elementToAdd, freqMap.getOrDefault(elementToAdd, 0) + 1);

            ans.add(freqMap.size());
        }

        return ans;
    }
}
