//{ Driver Code Starts
import java.util.*;

class Sorted_Array {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }
            Solution obj = new Solution();
            System.out.println(obj.transitionPoint(arr, n));
            T--;
        }
    }
}
// } Driver Code Ends




class Solution {
    int transitionPoint(int arr[], int n) {
        // code here
        if(arr[n-1] == 0) {
            return -1;
        }
        
        int start = 0;
        int end = n-1;
        int mid = start+end /2;
        int r = -1;
        
        while(start <= end) {
            mid = start + (end-start)/2;
            
            if(arr[mid] == 1){
                // if(arr[mid - 1] == 0){
                //     return mid;
                // }
                r = mid;
                end = mid - 1;
            }
            else {
                start = mid+1;
            }
        }return r;
    }
}