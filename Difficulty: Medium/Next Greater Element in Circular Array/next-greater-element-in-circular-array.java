//{ Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter ot = new PrintWriter(System.out);
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    Solution ob = new Solution();
		    long[] res = ob.nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        ot.print(res[i] + " ");
		    ot.println();
		}
        ot.close();
	}
}



// } Driver Code Ends




// User Function Template for JAVA

class Solution{
    public static long[] nextLargerElement(long[] arr, int n) 
    { 
        long a[]=new long[n];
        for(int i=0;i<n;i++)
        {
            int f=0;
            for(int j=i+1;j<n;j++)
            {
                if(arr[i]<arr[j])
                {
                    a[i]=arr[j];
                    f=1;
                    break;
                }
            }
            if(f==0)
            {
                for(int j=0;j<i;j++)
                {
                    if(arr[i]<arr[j])
                    {
                        a[i]=arr[j];
                        f=1;
                        break;
                    }
                }
            }
            if(f==0)
                a[i]=-1;
        }
        return a;
    } 
}