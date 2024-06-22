//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            sc.nextLine();
            String s = sc.next();
            Solution obj = new Solution();
            String ans = obj.postToPre(s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    static String postToPre(String post_exp) {
        // code here
        Stack<String> s = new Stack<>();
        String ans = "";
        int count = 0;
        for(int i = 0;i<post_exp.length();i++){
            char curr = post_exp.charAt(i);
            
            if(Character.isLetterOrDigit(curr)){
                String x = Character.toString(curr);
                s.push(x);
                count++;
            }
            else{
                if(count >= 2 || i == 0){
                    
                    String A = s.pop();
                    String B = s.pop();
                    count = count - 2;
                    ans = curr + B +  A;
                    s.push(ans);
                    count++;
               }
            }
    }
    return s.pop();
        
    }
}
