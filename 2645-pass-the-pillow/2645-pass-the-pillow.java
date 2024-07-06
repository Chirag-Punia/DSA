class Solution {
    public int passThePillow(int n, int time) {
        if(time < n) return time+1;
        int i = 1;
        int drn = 1;
        while(time > 0){
            if(i >= n) drn = -1;
            if(i == 1) drn = 1;
            i += drn;
            time--;
        }
        return i;
    }
}