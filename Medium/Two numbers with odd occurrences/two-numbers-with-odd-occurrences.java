//{ Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int Arr[]= new int[N];
            for(int i = 0; i < N; i++)
                Arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int[] ans = ob.twoOddNum(Arr,N);
            for(int i = 0; i < ans.length; i++)
            {
                System.out.print(ans[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


//User function Template for Java

//User function Template for Java
class Solution
{
    public int[] twoOddNum(int arr[], int N)
    {
        // code here
        int xor = 0;
        for(int i = 0;i<N;i++){
            xor = xor ^ arr[i];
        }
        //RightMost BIT
        int mask = (xor & xor - 1) ^ xor;
        int num1 = 0;
        int num2 = 0;
        for(int i = 0; i<N;i++){

            if((mask & arr[i]) > 0){
                num1 = num1 ^ arr[i];
            }
            else{
                num2 = num2 ^ arr[i];
            }
            
        }
        int[] ans = new int[2];
        if(num1 > num2){
            ans[0] = num1;
            ans[1] = num2;
        }
        else{
            ans[0] = num2;
            ans[1] = num1;
        }
        return ans;
    }
}