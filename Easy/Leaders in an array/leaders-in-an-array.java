//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.stream.*;

class Array {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PrintWriter ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim()); //Inputting the testcases
		
		while(t-->0){
		    
		    //input size of array
		    int n = Integer.parseInt(br.readLine().trim());
		    int arr[] = new int[n];
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    //inserting elements in the array
		    for(int i=0; i<n; i++){
		        arr[i] = Integer.parseInt(inputLine[i]);
		    }
		    
		    Solution obj = new Solution();
		    
		    StringBuffer str = new StringBuffer();
		    ArrayList<Integer> res = new ArrayList<Integer>();
		  
		    //calling leaders() function
		    res = obj.leaders(arr, n);
		    

		    for(int i=0; i<res.size(); i++){
		        ot.print(res.get(i)+" ");
		    }
		    
		    ot.println();
		}
		ot.close();
		
	}
}

// } Driver Code Ends


class Solution{
    //Function to find the leaders in the array.
    public static int max(int[] arr,int i,int j){
        int max = 0;
        for(int k = i;k<=j;k++){
            max = Math.max(arr[k],max);
        }
        return max;
    }
    
    public static int maxIndex(int[] arr,int i,int j){
        int max = 0;
        int idx = 0;
        for(int k = i;k<=j;k++){
            if(max < arr[k]){
                max = arr[k];
                idx = k;
            }
        }
        return idx;
    }
    static ArrayList<Integer> leaders(int arr[], int n){
        // Your code here
        ArrayList<Integer> ans = new ArrayList<>();
        
        //if it is equal to the maximum element on its right side
        int max =0;
        for(int i = n-1; i >=0;i--){
            if(arr[i] >= max){
                max = arr[i];
                ans.add(max);
            }
        }
        Collections.reverse(ans);
        return ans;
        
        //Greater than all the elements to its right side 
        
        // int i = 0;
        // while(i < n){
        //     int max = max(arr,i,n-1);
        //     int maxIndex = maxIndex(arr,i,n-1);
        //     i = maxIndex+1;
        //     ans.add(max);
        // }
        // return ans;
    }
}
