class Solution {
    public static double p(double x, int n) {
        if (n == 0) {
            return 1;
        }
        return x * p(x, n - 1);
    }

    public double myPow(double x, int n) {

        // FAST EXPONENTION
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        double ans = x;
        double temp = 1;
        // WHILE CONDITION IMPORTANT

        // Let's take an example:

        // suppose n = -2147483648 (which is -2^31, extreme negative value following
        // given constraint)

        // So according to this code, n = -n, and thus your n will be a positive value.
        // But 2147483648 is out of range for an Integer. So, instead of 2147483648, it
        // will convert it to -2147483648

        // 11000000000000000000000000000000 : -2147483648 >> 1 (right shift by 1)

        // This right shift will result -1073741824, i.e a negative value of n again. If
        // you go through with while loop, n value will become -1.

        // -1 is 1111111111111111, and right shift will always push 1 in left, so it
        // will go into TLE.

        // That's the reason, to avoid this issue, we use Unsigned Right shift(>>>),
        // that always push 0 to the left.

        while (n != 0) {
            if (n%2 == 1) {
                temp = ans * temp;
            }
            ans = ans * ans;

            // IMPORTANT
            n >>= 1;
        }
        return temp;

        // BRUTE FORCE
        // int t = n;
        // if (n < 0) {
        // n = n * -1;
        // }

        // double shortPower = p(x, n / 2);

        // if (n % 2 == 0) {
        // if(t < 0){
        // return 1/(shortPower * shortPower);
        // }
        // return shortPower * shortPower;
        // }
        // else{
        // if(t < 0){
        // return 1/(x * shortPower * shortPower);
        // }
        // return x * shortPower * shortPower;
        // }
    }
}