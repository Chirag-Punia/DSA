class Solution {
    String ans = "";

    public boolean isPalindrome(String s){
        int l=0,r = s.length()-1;
        while(l<r)
            if(s.charAt(l++) != s.charAt(r--))
                return false;
        return true;
    }

    void tmp(String s, int i, int j) {
        if (j >= s.length()) {
            return;
        }
        String curr = s.substring(i, j + 1);
        if (isPalindrome(curr) && curr.length() > ans.length()) {
            ans = curr;
        }

        tmp(s, i, j + 1);

        tmp(s, i + 1, i + 1);
    }

      public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i ; j <= s.length(); j++) {
                if (j - i > maxLen && isPalindrome(s.substring(i, j))) {
                    maxLen = j - i;
                    maxStr = s.substring(i, j);
                }
            }
        }

        return maxStr;
    }
}
