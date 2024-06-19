//{ Driver Code Starts
import java.io.*;
import java.util.*;
class Node
{
    int data;
    Node next;
    
    Node(int x)
    {
        data = x;
        next = null;
    }
}
class GfG
{
    public static void printList(Node node) 
    { 
        while (node != null)
        { 
            System.out.print(node.data);
            node = node.next; 
        }  
        System.out.println();
    } 
    public static void main(String args[])throws IOException
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Node head = new Node( s.charAt(0) - '0' );
                    Node tail = head;
                    for(int i=1; i<s.length(); i++)
                    {
                        tail.next = new Node( s.charAt(i) - '0' );
                        tail = tail.next;
                    }
                    Solution obj = new Solution();
                    head = obj.addOne(head);
                    printList(head); 
                }
        }
}
// } Driver Code Ends


/*
class Node{
    int data;
    Node next;
    
    Node(int x){
        data = x;
        next = null;
    }
} 
*/

class Solution

{
    public static Node reverse(Node current,Node prev){
        if(current == null){
            return prev;
        }
        Node next = current.next;
        current.next = prev;
        return reverse(next,current);
    }
    
    public static Node addOne(Node head) 
    { 
        //code here.
        if(head == null){
            return null;
        }
        
        Node rev = reverse(head,null);
        Node temp = rev;
        int carry = 1;
        while(temp != null){
            if(temp.data + carry > 9){
                temp.data = 0;
                carry = 1;
            }
            else{
                temp.data = temp.data + carry;
                carry = 0;
            }
            temp = temp.next;
        }
        head = reverse(rev,null);
        if(carry == 1){
            Node x = new Node(1);
            x.next = head;
            head = x;
        }
        return head;
        //BRUTE FORCE
        // List<Integer> arr = new ArrayList<>();
        // Node curr = head;
        // int digit = 0, num = 0;
        // while(curr != null){
        //     digit = curr.data;
        //     arr.add(digit);
        //     curr = curr.next;
        // }
        // int carry = 0;
        // if(arr.size() == 1){
        //     digit = arr.get(0);
        //     if(digit + 1 > 9){
        //         arr.set(0,1);
        //         arr.add(0);
        //     }
        //     else{
        //         arr.set(0,digit+1);
        //     }
            
        // }
        // else{
        //   for(int i = arr.size()-1 ;i>=0;i--){
        //     digit = arr.get(i);
        //     if(i ==  arr.size() - 1){
        //         arr.set(i,digit+1);
        //         if(digit+1 > 9){
        //             arr.set(i,0);
        //             carry = 1;
        //         }
        //     }
        //     else{
        //         arr.set(i,digit+carry);
        //         if(digit+carry > 9){
        //             arr.set(i,0);
        //             carry = 1;
        //         }
        //         else{carry = 0;}
        //     }
               
        //   } 
        //   if(carry == 1){
        //       arr.add(0,1);
        //   }
        // }
        
        
        // curr = new Node(-1);
        // Node temp = curr;
        // for(int i = 0;i<arr.size();i++){
        //     temp.next = new Node(arr.get(i));
        //     temp = temp.next;
        // }
        
        // return curr.next;
}
}
