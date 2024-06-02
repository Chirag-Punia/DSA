class Solution {

    static int mod =(int)(1e9)+7;
    static long helper(long p, long q){
        if(q==0) return 1;
        long smallpow=helper(p,q/2);

        if(q%2==0){
            return ((smallpow%mod)*(smallpow%mod))%mod;
        }
        else{
            return (p*(smallpow%mod)*(smallpow%mod))%mod;
        }
    }   
    public int countGoodNumbers(long n) {
        

        long a = helper(5,(n+1)/2)%mod;
        long b = helper(4,n/2)%mod;
        
        return (int)((a*b)%mod);
    }
}