class Solution {
    public static double p(double x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * p(x, n - 1);
    }

    public double myPow(double x, int n) {


        //FAST EXPONENTION
        if(n < 0){
            n = -n;
            x = 1 / x;
        }
        double ans = x;
        double temp = 1;
        while(n != 0){
            if((n & 1) == 1){
            temp =  ans * temp;
        }
            ans = ans * ans;
            n >>>= 1;
        }
        return temp;


        //BRUTE FORCE
        // int t = n;
        // if (n < 0) {
        //     n = n * -1;
        // }

        // double shortPower = p(x, n / 2);

        // if (n % 2 == 0) {
        //     if(t < 0){
        //         return 1/(shortPower * shortPower);
        //     }
        //     return shortPower * shortPower;
        // }
        // else{
        //     if(t < 0){
        //         return 1/(x * shortPower * shortPower);
        //     }
        //     return x * shortPower * shortPower;
        // }
    }
}