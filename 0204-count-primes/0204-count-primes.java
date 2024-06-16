class Solution {
    public static boolean isPrime(int n) {
        if (n == 2 || n == 3) {
            return true;
        } else if (n == 1 || n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        for (int i = 5; i * i <= n; i = i + 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }

    public static boolean[] isPrime2(int n){
        boolean[] arr = new boolean[n+1];
        for(int i = 0;i<= n;i++){
            arr[i] = true;
        }
        for(int i = 2;i*i<=n;i++){
           if(arr[i] == true){
                for(int j = i*i;j<=n;j = j + i){
                    arr[j] = false;
                }
           } 
        }
        return arr;
    }

    public int countPrimes(int n) {
        int count = 0;
        boolean[] arr = isPrime2(n);
        for (int i = 2; i < n; i++) {
            if (arr[i]) {
                count++;
            }
        }
        return count;

    }
}