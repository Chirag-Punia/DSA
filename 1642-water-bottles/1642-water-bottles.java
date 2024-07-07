class Solution {
    public int numWaterBottles(int nb, int ne) {
        int ans = nb;
        while((nb/ne) > 0){
            int filled = nb / ne;
            int empty = nb % ne;
            ans = ans + filled;
            nb = filled + empty;
        }
        return ans;
    }
}