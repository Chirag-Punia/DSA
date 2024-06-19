//{ Driver Code Starts
import java.io.*;
import java.util.*;


class Node
{
    int data;
    Node next,prev;
    
    Node(int x)
    {
        data = x;
        next = null;
        prev = null;
    }
    
    public static Node inputList(BufferedReader br) throws IOException
    {
        int n = Integer.parseInt(br.readLine().trim()); // Length of Linked List
        
        String[] s = br.readLine().trim().split(" ");
        Node head = new Node(Integer.parseInt(s[0])), tail = head;
        for(int i = 1; i < s.length; i++){
            Node temp=new Node(Integer.parseInt(s[i]));
            tail.next = temp;
            tail.next.prev = tail;
            tail = tail.next;
        }
        return head;
    }
    
    public static void printList(Node node)
    {
        while (node != null)
        { 
    		System.out.print(node.data + " ");
    		node = node.next; 
    	}  
    	System.out.println();
    }
}


class IntMatrix
{
    public static int[][] input(BufferedReader br, int n, int m) throws IOException
    {
        int[][] mat = new int[n][];
        
        for(int i = 0; i < n; i++)
        {
            String[] s = br.readLine().trim().split(" ");
            mat[i] = new int[s.length];
            for(int j = 0; j < s.length; j++)
                mat[i][j] = Integer.parseInt(s[j]);
        }
        
        return mat;
    }
    
    public static void print(int[][] m)
    {
        for(var a : m)
        {
            for(int e : a)
                System.out.print(e + " ");
            System.out.println();
        }
    }
    
    public static void print(ArrayList<ArrayList<Integer>> m)
    {
        if(m.size()==0){
            System.out.println("-1");
        }else{
            for(var a : m)
            {
                System.out.print("(" + a.get(0) + "," + a.get(1) + ")" + " ");
            }
            System.out.println();
        }
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            int target; 
            target = Integer.parseInt(br.readLine());
            
            
            Node head = Node.inputList(br);
            
            Solution obj = new Solution();
            ArrayList<ArrayList<Integer>> res = obj.findPairsWithGivenSum(target, head);
            
            IntMatrix.print(res);
            
        }
    }
}

// } Driver Code Ends


/*

Definition for singly Link List Node
class Node
{
    int data;
    Node next,prev;
    
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}

You can also use the following for printing the link list.
Node.printList(Node node);
*/

class Solution {
    
     
    
    public static ArrayList<ArrayList<Integer>> findPairsWithGivenSum(int target, Node head) {
        // code here
        if(head == null){
            return null;
        }
        Node left = head;
        Node right = head;
        while(right.next != null){
            right = right.next;
        }
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

        while(left!= null && right!= null && left.data < right.data){
            int sum = left.data + right.data;
            if(sum == target){
                arr.add(left.data);
                arr.add(right.data);
                ans.add(arr);
                arr = new ArrayList<>();
                left = left.next;
                right = right.prev;
            }
            else if(sum < target){
                left = left.next;
            }
            else{
                right = right.prev;
            }
            
        }
        return ans;
        
        
        
        
        
        //BRUTE FORCE
        // Node curr = head;
        // ArrayList<Integer> arr = new ArrayList<>();
        // ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        // HashMap<Integer,Integer> mpp = new HashMap<>();
        // while(curr != null && curr.data <= target){
        //     Node x = curr.next;
        //     while(x != null && x.data <= target){
        //         if(curr.data + x.data == target){
        //             arr.add(curr.data);
        //             arr.add(x.data);
        //             ans.add(arr);
        //             arr = new ArrayList<>();
        //         }
        //         x = x.next;
        //     }
        //     curr = curr.next;
        // }
        // return ans;
        
    }
}
        
