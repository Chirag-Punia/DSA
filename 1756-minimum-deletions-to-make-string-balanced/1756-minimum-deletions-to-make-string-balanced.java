class Solution {
    public int minimumDeletions(String s) {
        int b_count = 0;
        int min_deletions = 0;
        
        for (char c : s.toCharArray()) {
            if (c == 'b') {
                b_count++;
            } else {
                min_deletions = Math.min(min_deletions + 1, b_count);
            }
        }
        
        return min_deletions;
    }
}