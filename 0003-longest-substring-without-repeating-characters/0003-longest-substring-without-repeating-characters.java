class Solution {
    public int count(String s) {
        HashMap<Character, Integer> mpp = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            mpp.put(curr, mpp.getOrDefault(curr, 0) + 1);
            if (mpp.getOrDefault(curr, 0) > 1)
                return -1;
        }
        return s.length();
    }

    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0)
            return 0;
        HashMap<Character, Integer> mpp = new HashMap<>();
        int left = 0;
        int right = 0;
        int n = s.length();
        int maxLen = 0;
        while (left < n && right < n) {
            char rightChar = s.charAt(right);
            if(mpp.containsKey(rightChar) && mpp.get(rightChar) >= left) {
                left = mpp.get(rightChar) + 1;
            }
            mpp.put(rightChar, right);
            maxLen = Math.max(maxLen, right - left + 1);
            right++;
        }
        return maxLen;

        // BRUTE FORCE
        // int ans = 0;
        // for(int i = 0;i<s.length();i++){
        // HashSet<Character> seen = new HashSet<>();
        // for(int j = i;j<s.length();j++){
        // char currChar = s.charAt(j);
        // if(seen.contains(currChar))break;
        // seen.add(currChar);
        // ans = Math.max(ans,j - i + 1);
        // }
        // }
        // return ans;
    }
}