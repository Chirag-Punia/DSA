//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0)
        {
            int N = sc.nextInt();

            Solution ob = new Solution();
            int ans  = ob.setBit(N);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java
class Solution{
    static int setBit(int N){
        // code here
        // int j = N;
        // int count = 0;
        // while(j > 0){
        //     if((j & 1) != 1){
        //         break;
        //     }
        //     count++;
        //     j >>= 1;
        // }
        // return (1 << count) | N;
        
        
        return N | (N + 1);
    }
}