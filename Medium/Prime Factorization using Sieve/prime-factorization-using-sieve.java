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
    static void sieve(){}
    public static int[] isPrime2(int n){
        int[] arr = new int[n+1];
        for(int i = 0;i<= n;i++){
            arr[i] = i;
        }
        for(int i = 2;i*i<=n;i++){
           if(arr[i] == i){
                for(int j = i*i;j<=n;j = j + i){
                    if(arr[j] != 1){
                        arr[j] = i;
                    }
                }
           } 
        }
        return arr;
    }
    static List<Integer> findPrimeFactors(int N) {
        // code here
        int[] arr = isPrime2(N);
        List<Integer> nums = new ArrayList<>();
        
        while(N > 1){
            nums.add(arr[N]);
            N = N / arr[N];
        }
        Collections.sort(nums);
        return nums;
        
        //WITHOUT USING SIEVE
        // List<Integer> nums = new ArrayList<>();
        // for(int i = 2;i*i<=N;i++){
        //     if(N % i == 0){
        //         while(N % i == 0){
        //             nums.add(i);
        //             N = N / i;
        //         }
        //     }
            
        // }
        // if(N != 1){
        //     nums.add(N);
        // }
        // return nums;
        
    }
}
