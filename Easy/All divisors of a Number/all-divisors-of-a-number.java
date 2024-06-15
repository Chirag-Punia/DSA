//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            int n;
            n = Integer.parseInt(br.readLine());

            Solution obj = new Solution();
            obj.print_divisors(n);
            System.out.println();
        }
    }
}

// } Driver Code Ends


class Solution {
    public static void print_divisors(int n) {
        // code here
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i = 1;i<= Math.sqrt(n);i++){
            if(n % i == 0){
                System.out.print(i + " ");
                if(n / i != i){
                    arr.add(n / i);
                }
            }
        }
        
        for(int i = arr.size() - 1; i >= 0;i--){
            
            System.out.print(arr.get(i) + " ");
            
        }
    }
}
