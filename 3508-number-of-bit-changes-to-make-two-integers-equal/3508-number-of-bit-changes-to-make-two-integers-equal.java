class Solution {
    public int minChanges(int n, int k) {
        int bit = n ^ k;
        int cnt = 0;
        if ((n | k) != n) {
            return -1;
        }
        while(bit > 0){
            if((bit & 1) == 1) cnt++;
            bit = bit >> 1;
        }

        return cnt;
    }
}