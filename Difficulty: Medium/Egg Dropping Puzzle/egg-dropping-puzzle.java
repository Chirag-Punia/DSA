//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GfG { 
    
	public static void main (String[] args) throws IOException  {
	    
	    //reading input using BufferedReader class
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//reading total testcases
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    
		    //reading number of eggs and floors
		    String inputLine[] = br.readLine().trim().split(" ");
		    
		    int n = Integer.parseInt(inputLine[0]);
		    int k = Integer.parseInt(inputLine[1]);
		    
		    //calling eggDrop() method of class
		    //EggDrop
		    System.out.println(new Solution().eggDrop(n, k));
		}
	}
}



// } Driver Code Ends




class Solution 
{
    
    static int[][] dp = new int[300][300];
    
    public Solution() {
        for(int i = 0; i < 300; i++) {
            for(int j = 0; j < 300; j++) {
                dp[i][j] = -1;
            }
        }
    }
    //Function to find minimum number of attempts needed in 
    //order to find the critical floor.
    static int eggDrop(int floors, int eggs) 
	{
	    if(floors == 1 && eggs == 1) return 1;
	    
	    if(floors == 1 && eggs != 1) return eggs; //try all floor from top
	    
	    if(eggs == 1) return 1;
	    
	    if(dp[floors][eggs] != -1) return dp[floors][eggs];
	    
	    int ans = eggs;
	    

	    for(int x = 2; x < eggs; x++) {
	        int steps = 1 + Math.max(eggDrop(floors, x - 1), eggDrop(floors - 1, eggs - x));
	        ans = Math.min(ans, steps);
	    }
	    
	    dp[floors][eggs] = ans;
	    
	    return ans;
	}
}