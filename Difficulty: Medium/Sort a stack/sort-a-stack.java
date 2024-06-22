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
    
    public static void push(Stack<Integer> s,int n){
        if(s.isEmpty() || s.peek() < n){
            s.push(n);
            return;
        }
        int ele = s.pop();
        push(s,n);
        s.push(ele);
        return;
    }
    public static void SORT(Stack<Integer> s){
        if(s.isEmpty()){
            return;
        }
        int ele = s.pop();
        SORT(s);
        push(s,ele);
        return;
    }
    
    public Stack<Integer> sort(Stack<Integer> s) {
        // add code here.
        
        SORT(s);
        return s;
        
       
    }
}