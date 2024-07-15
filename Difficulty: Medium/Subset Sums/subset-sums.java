//{ Driver Code Starts

// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int N = sc.nextInt();
            ArrayList<Integer> arr = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                arr.add(sc.nextInt());
            }
            Solution ob = new Solution();

            ArrayList<Integer> ans = ob.subsetSums(arr, N);
            Collections.sort(ans);
            for (int sum : ans) {
                System.out.print(sum + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java//User function Template for Java
class Solution {
    ArrayList<Integer> ans;
    void tmp(ArrayList<Integer> arr,int i,int s){
        if(i >= arr.size()){ans.add(s);return;}
        tmp(arr,i+1,s+arr.get(i));
        tmp(arr,i+1,s);
    }
    ArrayList<Integer> subsetSums(ArrayList<Integer> arr, int n) {
        // code here
        ans = new ArrayList<>();
        tmp(arr,0,0);
        return ans;
    }
}