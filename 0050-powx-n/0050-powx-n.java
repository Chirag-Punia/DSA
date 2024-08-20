class Solution {

    public double myPow(double x, int n) {

        // FAST EXPONENTION
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double ans = x;
        double temp = 1;

        while (n != 0) {
            if (n % 2 == 1) {
                temp = ans * temp;
                n = n - 1;
            }
            else{
                ans = ans * ans;
                n >>>= 1;
            }
            
        }
        return temp;

    }
}