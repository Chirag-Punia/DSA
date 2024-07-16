class Solution {
    public int longestOnes(int[] t, int k) {
        int l = 0, r = 0, m = 0, c = 0,n=t.length;
        while (r < n) {
            if (t[r] == 0)
                ++c;
            while (k < c) {
                if (t[l] == 0)
                    --c;
                l++;
            }
            m = Math.max(m, r - l + 1);
            r++;
        }

        return m;

    }
}