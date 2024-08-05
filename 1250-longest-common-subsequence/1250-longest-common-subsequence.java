class Solution {
    HashMap<String, Integer> memo;

    int tmp(String s1, String s2, int i, int j) {
        String key = i + "" + j;
        if (i >= s1.length() || j >= s2.length())
            return 0;
        if (memo.containsKey(key))
            return memo.get(key);
        if (s1.charAt(i) == s2.charAt(j))
            memo.put(key,1 + tmp(s1, s2, i + 1, j + 1));
        else 
            memo.put(key, Math.max(tmp(s1, s2, i + 1, j), tmp(s1, s2, i, j + 1)));
        return memo.get(key);
    }

    public int longestCommonSubsequence(String s1, String s2) {
        memo = new HashMap<>();
        if (s1.equals(s2))
            return s1.length();
        return tmp(s1, s2, 0, 0);
    }
}