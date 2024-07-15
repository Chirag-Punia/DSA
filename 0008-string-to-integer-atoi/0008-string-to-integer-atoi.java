class Solution {
    public int myAtoi(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        s = s.trim();

        if (s.length() == 0) {
            return 0;
        }

        int sign = 1;
        int start = 0;
        long result = 0;

        if (s.charAt(0) == '-' || s.charAt(0) == '+') {
            if (s.charAt(0) == '-') {
                sign = -1;
            }
            start++;
        }

        for (int i = start; i < s.length(); i++) {
            char curr = s.charAt(i);

            if (!Character.isDigit(curr)) {
                break;
            }

            result = result * 10 + (curr - '0');

            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
        }

        return sign * (int) result;
    }
}