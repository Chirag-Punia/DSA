//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.io.*;

class GFG{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t > 0){
			int n = sc.nextInt();
			int[][] a = new int[n][n];
			for(int i = 0; i < n; i++)
				for(int j = 0; j < n; j++)
					a[i][j] = sc.nextInt();
			Solution T = new Solution();
			ArrayList<Integer> arr= T.mergeKArrays(a, n);
			for(int i = 0; i < n*n ; i++)
			    System.out.print(arr.get(i)+" ");
		    System.out.println();
		    
		    t--;
		}
	}
}


// } Driver Code Ends


//User function Template for Java


class Solution
{
    public static class Pair implements Comparable<Pair>{
        int i;
        int[] arr;
        Pair(int i,int[] arr){
            this.i = i;
            this.arr = arr;
        }
        @Override
        public  int compareTo(Pair other){
            return Integer.compare(this.arr[this.i],other.arr[other.i]);
        }
    }
    //Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr,int k) 
    {
        // Write your code here.
        PriorityQueue<Pair> q = new PriorityQueue<>();
        for(int i = 0;i<k;i++){
            Pair temp = new Pair(0,arr[i]);
            q.offer(temp);
        }
        ArrayList<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            Pair t = q.remove();
            ans.add(t.arr[t.i]);
            int e = t.i + 1;
            if(e < k) {
                Pair x = new Pair(e,t.arr);
                q.offer(x);
            }
            
        }
        return ans;
        
        
        
    }
}