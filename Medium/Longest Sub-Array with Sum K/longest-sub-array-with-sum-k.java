//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;


class Array {
    
    // Driver code
	public static void main (String[] args) throws IOException{
		// Taking input using buffered reader
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int testcases = Integer.parseInt(br.readLine());
		
		// looping through all testcases
		while(testcases-- > 0){
		    String line = br.readLine();
		    String[] element = line.trim().split("\\s+");
		    int sizeOfArray = Integer.parseInt(element[0]);
		    int K = Integer.parseInt(element[1]);
		    
		    int arr [] = new int[sizeOfArray];
		    
		    line = br.readLine();
		    String[] elements = line.trim().split("\\s+");
		    for(int i = 0;i<sizeOfArray;i++){
		        arr[i] = Integer.parseInt(elements[i]);
		    }
		    
		    Solution obj = new Solution();
		    int res = obj.lenOfLongSubarr(arr, sizeOfArray, K);
		    
		    System.out.println(res);
		}
	}
}



// } Driver Code Ends


//User function Template for Java

class Solution{
    
    
    // Function for finding maximum and value pair
    public static int lenOfLongSubarr (int A[], int N, int K) {
        //Complete the function
    
    //HASHING TECHNIQUE
    
    
    int ans = 0;
    HashMap<Integer,Integer> mpp = new HashMap<>();
    int prefixSum = 0;
    for(int i = 0 ;i < N; i++){
        prefixSum = prefixSum + A[i];
        if(prefixSum == K){
            ans = Math.max(ans,i+1);
        }
        int rem = prefixSum - K;
        
        if(mpp.containsKey(rem)){
            ans = Math.max(ans,i - mpp.get(rem));
        }
        if(!(mpp.containsKey(prefixSum))){
            //to insure longest subArray
            mpp.put(prefixSum,i);
        }
    }
    return ans;
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
   // only if array Consist of positives;
    // int i = 0;
    // int j = 0;
    // int sum = A[0];
    // int ans = 0;
    // while (j < N) {

    //     while(i<=j && sum > K){
    //         sum = sum  -  A[i];
    //         i++;
    //     }
        
    //     if(sum == K){
    //         ans = Math.max(ans,j-i+1);
    //     }
        
    //     j++;
    //     if(j < N){
            
    //     sum  = sum +  A[j];
        
    //     }

    // }
    // return ans;


        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        
        //OPTIMIZED BRUTE FORCE
        // int ans = 0;
        // for(int i = 0; i<N;i++){
        //         int sum = 0;
        //         for(int j = i;j<N;j++){
        //             sum = sum + A[j];
                    
                    
        //           if(sum == K){
        //               ans = Math.max(ans,j - i + 1);
        //           }
        //         }
        //     }
        //     return ans;
    
        
        
        
        
        //BRUTE FORCE
        // int ans = 0;
        // for(int i = 0; i<N;i++){
        //         for(int j = i;j<N;j++){
        //             int sum = 0;
        //             int count = 0;
        //             for(int k = i;k<=j;k++){
        //                 sum = sum + A[k];
        //                 count++;
        //             }
        //           if(sum == K){
        //               ans = Math.max(count,ans);
        //           }
        //         }
        //     }
        //     return ans;
        
        
        
        
        
        
        
        
        
    }
    
    
}


