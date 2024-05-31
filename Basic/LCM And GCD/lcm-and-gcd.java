//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            Long A = Long.parseLong(S[0]);
            Long B = Long.parseLong(S[1]);

            Solution ob = new Solution();
            Long[] ptr = ob.lcmAndGcd(A,B);
            
            System.out.print(ptr[0]);
            System.out.print(" ");
            System.out.println(ptr[1]);
        }
    }
}
// } Driver Code Ends


class Solution {
    public static Long gcd(Long A, Long B){
        if(B == 0){
            return A;
        }
        return gcd(B,A%B);
        
    }
    
    static Long[] lcmAndGcd(Long A , Long B) {
        Long ans  = gcd(A,B);
        Long arr[] = {((A*B)/ans),ans};
        return arr;
    }
    
};