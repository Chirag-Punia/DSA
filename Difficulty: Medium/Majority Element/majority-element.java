//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;
import java.lang.*;

class Geeks
{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n =sc.nextInt();
            int arr[] = new int[n];
            
            for(int i = 0; i < n; i++)
             arr[i] = sc.nextInt();
             
           System.out.println(new Solution().majorityElement(arr, n)); 
        }
    }
}
// } Driver Code Ends




//User function Template for Java

class Solution
{
    static int majorityElement(int a[], int size)
    {
        // your code here
        // 3 1 3 3 2
        //Brute Force Approach
        // int element = size/2;
        // //System.out.print(element);
        // for(int i = 0 ; i < size ; i++){
        //     int num = a[i];
        //     int count = 0;
        //     for(int j = 0 ; j < size ; j++){
        //         if(a[j] == num)
        //             count++;
        //     }
        //     if(count > element)
            
        //     return num;
        // }
        // return -1;
        
        
        HashMap<Integer,Integer> mpp = new HashMap<>();
        int element = size/2;
        
        //Inserting values in Hashmap
        for(int i = 0 ; i<size ; i++){
            int value = mpp.getOrDefault(a[i], 0);
            mpp.put(a[i],value+1);
        }

        for (Map.Entry<Integer, Integer> it : mpp.entrySet()) {
            if (it.getValue() > (size / 2)) {
                return it.getKey();
            }
        }
        
        return -1;
    }
}