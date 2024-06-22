//{ Driver Code Starts
import java.util.*;
import java.util.Scanner;
import java.util.Stack;

class SortedStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            Stack<Integer> s = new Stack<>();
            int n = sc.nextInt();
            while (n-- > 0) s.push(sc.nextInt());
            GfG g = new GfG();
            Stack<Integer> a = g.sort(s);
            while (!a.empty()) {
                System.out.print(a.peek() + " ");
                a.pop();
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends

/*Complete the function below*/
class GfG {
    public static int getSmallest(Stack<Integer> s,int min){
        
        if(s.isEmpty()){
            return min;
        }
        
        return getSmallest(s,Math.min(s.pop(),min));
        
    }
    
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        
        Stack<Integer> ans = new Stack<>();
        List<Integer> arr = new ArrayList<>();
        while(!s.isEmpty()){
            arr.add(s.pop());
        }
        Collections.sort(arr);
        for(int i = 0;i<arr.size();i++){
            ans.push(arr.get(i));
        }
        return ans;
        
        
        
    }
}