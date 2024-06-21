//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {

    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            System.out.println(
                new Solution().infixToPostfix(br.readLine().trim()));
        }
    }
}
// } Driver Code Ends


class Solution {

    static int prec(char c) {
        if (c == '^')
            return 3;
        else if (c == '/' || c == '*')
            return 2;
        else if (c == '+' || c == '-')
            return 1;
        else
            return -1;
    }
    public static String infixToPostfix(String exp) {
        // Your code here
        StringBuilder ans = new StringBuilder();
        Stack < Character > s = new Stack < > ();
        for (int i = 0; i < exp.length(); i++) {
            char curr = exp.charAt(i);
            if (Character.isLetterOrDigit(curr)) {
                ans.append(curr);
            } else if (curr == '(') {
                s.push(curr);
            } else if (curr == ')') {
                while (!s.isEmpty() && s.peek() != '(') {
                    ans.append(s.pop());
                }
                if(!s.isEmpty() && s.peek() == '('){
                    s.pop();
                }
                
            } else {
                while (!s.isEmpty() && (prec(curr) <= prec(s.peek()))) {
                    ans.append(s.pop());
                }
                s.push(curr);
            }
        }
        while (!s.isEmpty()) {
            ans.append(s.pop());
        }
        return ans.toString();
    }
}