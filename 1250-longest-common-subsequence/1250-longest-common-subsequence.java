class Solution {
    HashMap<String, Integer> memo;

    int tmp(String s1, String s2, int i, int j) {
        String key = i + "" + j;
        if (i >= s1.length() || j >= s2.length())
            return 0;
        if (memo.containsKey(key))
            return memo.get(key);
        if (s1.charAt(i) == s2.charAt(j))
            return 1 + tmp(s1, s2, i + 1, j + 1);
        memo.put(key, Math.max(tmp(s1, s2, i + 1, j), tmp(s1, s2, i, j + 1)));
        return memo.get(key);
    }

    int tabulation(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[][] dp = new int[n+1][m+1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];
    }

     int tabulation2(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        int[] ahead = new int[m+1];
        int[] prev = new int[m+1];
        for (int i = n-1; i >= 0; i--) {
            for (int j = m-1; j >= 0; j--) {
                if (s1.charAt(i) == s2.charAt(j))
                    prev[j] = 1 + ahead[j + 1];
                else {
                    prev[j] = Math.max(ahead[j], prev[j + 1]);
                }
            }
            int[] temp = prev;
            prev = ahead;
            ahead = temp;
        }
        return ahead[0];
    }

    public int longestCommonSubsequence(String s1, String s2) {
        memo = new HashMap<>();
        if (s1.equals(s2))
            return s1.length();
        return tabulation2(s1, s2);
    }
}