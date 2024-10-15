class Solution {
    public long minimumSteps(String s) {
        long countOnes = 0;
        long swaps = 0;
        
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                countOnes++;
            } else if (s.charAt(i) == '0') {
                swaps += countOnes;
            }
        }
        
        return swaps;
    }
}
