//{ Driver Code Starts
//Initial Template for Java


import java.util.*;
import java.io.*;
import java.lang.*;

class Main
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t  =Integer.parseInt(read.readLine());
        
        while(t-- > 0)
        {
            String st[] = read.readLine().trim().split(" ");
            int N = Integer.parseInt(st[0]);
            int M = Integer.parseInt(st[1]);
            
            int arr1[] = new int[N];
            int arr2[] = new int[M];
            
            st = read.readLine().trim().split(" ");
            for(int i = 0; i < N; i++)
              arr1[i] = Integer.parseInt(st[i]);
            
            st = read.readLine().trim().split(" ");  
            for(int i = 0; i< M; i++)
              arr2[i] = Integer.parseInt(st[i]);
            
            Solution obj = new Solution();
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = obj.findUnion(arr1, arr2, N, M);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println(); 
        }
    }
}



// } Driver Code Ends


//User function Template for Java

//arr1,arr2 : the arrays
// n, m: size of arrays
class Solution {
  //Function to return a list containing the union of the two arrays.
  public static ArrayList < Integer > findUnion(int arr1[], int arr2[], int n, int m) {

    //TWO--POINTER APPROACH
    int i = 0;
    int j = 0;
    ArrayList < Integer > arr = new ArrayList < > ();
    
    if (arr1[0] >= arr2[0]) {
        if(arr1[0] == arr2[0]){
            arr.add(arr2[0]);
           
            i++;
        }
        else{
            arr.add(arr2[0]);
            
        }
        j++;
      
    } else {
      arr.add(arr1[0]);
      i++;
    }

    while (i < n && j < m) {
      if(arr1[i] <= arr2[j]){
          if(arr.size() == 0 || arr.get(arr.size() - 1) != arr1[i]) {     
              arr.add(arr1[i]);
          }
          i++;
      }
     
      else{
          if(arr.size() == 0 || arr.get(arr.size() - 1) != arr2[j]) {     
              arr.add(arr2[j]);
          }
          j++;
      }
    }

    while (i < n) {
      if (arr.get(arr.size() - 1) != arr1[i]) {
        arr.add(arr1[i]);
      }
      i++;
    }
    while (j < m) {
      if (arr.get(arr.size() - 1) != arr2[j]) {
        arr.add(arr2[j]);
      }
      j++;
    }

    return arr;

    // BRUTE FORCE
    // HashSet<Integer> set = new HashSet<>();
    // ArrayList<Integer> arr = new ArrayList<>();
    // for(int i = 0;i<n;i++){
    //     set.add(arr1[i]);
    // }
    // for(int i = 0;i<m;i++){
    //     set.add(arr2[i]);
    // }
    // for(Integer element : set){
    //     arr.add(element);
    // }
    // Collections.sort(arr);
    // return arr;
  }
}



