class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashMap<Character, Integer> mpp = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        int maxLen = 0;
        while (right < n) {
            char rightChar = s.charAt(right);
            if(mpp.containsKey(rightChar) && mpp.get(rightChar) >= left) {
                left = mpp.get(rightChar) + 1;
            }
            mpp.put(rightChar, right);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;
    }
}