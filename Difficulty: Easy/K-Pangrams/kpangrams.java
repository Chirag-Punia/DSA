//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine().trim());
        while (t-- > 0) {
            String str = sc.nextLine();
            int k = Integer.parseInt(sc.nextLine().trim());
            Solution obj = new Solution();
            if (obj.kPangram(str, k))
                System.out.println("true");
            else
                System.out.println("false");
        }
    }
}
// } Driver Code Ends



// User function Template for Java
class Solution 
{
    boolean kPangram(String str, int k) 
    {
        StringBuffer sb = new StringBuffer();
        Set<Character> set = new HashSet<>();
        char c;
        for(int i=0;i<str.length();i++)
        {
            c=str.charAt(i);
            if(Character.isLetter(c))
            {
                sb.append(c);
                set.add(c);
            }
        }
        if(sb.length()<26)
            return false;
        else if(set.size()==26 || set.size()>=26-k)
            return true;
        else
            return false;
    }
}