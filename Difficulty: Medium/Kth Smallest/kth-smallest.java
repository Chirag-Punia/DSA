//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		Scanner sc=new Scanner(System.in);
		PrintWriter out = new PrintWriter(System.out);
		int t=sc.nextInt();
		
		while(t-->0)
		{
		    int n=sc.nextInt();
		    
		    int arr[]=new int[n];
		    
		    for(int i=0;i<n;i++)
		    arr[i]=sc.nextInt();
		    
		    int k=sc.nextInt();
		    Solution ob = new Solution();
		    out.println(ob.kthSmallest(arr, 0, n-1, k));
		}
		out.flush();
	}
}

// } Driver Code Ends


//User function Template for Java

class Solution{
    public static void heapify(int i, int[] arr, int n) {
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        int largest = i;

        if (left < n && arr[left] < arr[largest]) largest = left;
        if (right < n && arr[right] < arr[largest]) largest = right;

        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            heapify(largest, arr, n);
        }
    }
    public static int kthSmallest(int[] nums, int l, int r, int k) 
    { 
        //Your code here
        int n = nums.length;
        int temp = -1;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(i, nums, n);
        }

        for (int i = n - 1; i >= n - k; i--) {

            temp = nums[0];
            nums[0] = nums[i];
            nums[i] = temp;
            heapify(0, nums, i);

        }

        return temp;
        
        
        //BRUTE FORCE
        // PriorityQueue<Integer> p = new PriorityQueue<>();
        // while(l <= r){
        //     p.add(arr[l]);
        //     l++;
        // }
        // int temp = -1;
        // while(k > 0){
        //     temp = p.remove();
        //     k--;
        // }
        // return temp;
        
    } 
}
