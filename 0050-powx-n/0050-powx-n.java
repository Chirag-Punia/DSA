class Solution {
    public static double p(double x,int n){
        if(n == 0){
            return 1;
        }
        return x*p(x,n-1);
    }
     
    
    public double myPow(double x, int n) {
    return Math.pow(x,n);
}
}