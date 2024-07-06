class Solution {
    public int passThePillow(int n, int time) {

        if ((time / (n - 1)) % 2 == 0) {
            return (time % (n - 1)) + 1;
        } else {
            return n - (time % (n - 1));
        }

        // int i = 1;
        // int drn = 1;
        // while(time > 0){
        // if(i >= n) drn = -1;
        // if(i == 1) drn = 1;
        // i += drn;
        // time--;
        // }
        // return i;
    }
}