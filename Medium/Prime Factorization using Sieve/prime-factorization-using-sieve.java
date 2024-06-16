//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            int n = sc.nextInt();
            Solution obj = new Solution();
            obj.sieve();
            List<Integer> ans = obj.findPrimeFactors(n);
            for (int e : ans) {
                System.out.print(e + " ");
            }
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // You must implement this function
    static void sieve(){
        
    }
    public static boolean[] isPrime(int n) {
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

    static List<Integer> findPrimeFactors(int N) {
        // code here
        List<Integer> nums = new ArrayList<>();
        for(int i = 2;i*i<=N;i++){
            if(N % i == 0){
                nums.add(i);
                N = N / i;
                while(N % i == 0){
                    nums.add(i);
                    N = N / i;
                }
            }
            
        }
        if(N != 1){
            nums.add(N);
        }
        return nums;
        
    }
}
