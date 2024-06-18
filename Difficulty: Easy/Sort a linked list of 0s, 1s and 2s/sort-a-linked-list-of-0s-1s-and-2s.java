//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node next;

    Node(int key) {
        data = key;
        next = null;
    }
}

public class Driverclass {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int t = Integer.parseInt(in.readLine().trim());

        while (t-- > 0) {
            int n = Integer.parseInt(in.readLine().trim());
            String s[] = in.readLine().trim().split(" ");
            Node head = new Node(Integer.parseInt(s[0]));
            Node tail = head;
            for (int i = 1; i < n; i++) {
                tail.next = new Node(Integer.parseInt(s[i]));
                tail = tail.next;
            }

            head = new Solution().segregate(head);
            printList(head, out);
            out.println();
        }
        out.close();
    }

    public static void printList(Node head, PrintWriter out) {
        if (head == null) return;

        Node temp = head;
        while (temp != null) {
            out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}
// } Driver Code Ends


// User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution {
    // Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head) {
        // add your code here
        Node zeroHead = new Node(-1);
        Node oneHead = new Node(-1);
        Node twoHead = new Node(-1);
        
        Node zero = zeroHead;
        Node one = oneHead;
        Node two = twoHead;
        
        Node curr = head;
        
        while(curr != null){
            
            if(curr.data == 0) {
                zero.next = curr;
                zero = zero.next;

            }
            else if(curr.data == 1){
                one.next = curr;
                one = one.next;
 
            }
            else if(curr.data == 2){
                two.next = curr;
                two = two.next;

            }
            curr = curr.next;
        }
        
        
        zero.next = (oneHead.next) != null?oneHead.next:twoHead.next;
        one.next = twoHead.next;
        two.next = null;
        
        return zeroHead.next;
        
        
        //BRUTE FORCE
        // if(head == null || head.next == null){
        //     return head;
        // }
        // Node curr = head;
        // int zeroCnt = 0, oneCnt = 0, twoCnt = 0;
        // while(curr != null){
        //     if(curr.data == 0) zeroCnt++;
        //     else if(curr.data == 1) oneCnt++;
        //     else if(curr.data == 2) twoCnt++;
        //     curr = curr.next;
        // }
        // curr = head;
        // while(zeroCnt > 0){
        //     curr.data = 0;
        //     curr = curr.next;
        //     zeroCnt--;
        // }
        // while(oneCnt > 0){
        //     curr.data = 1;
        //     curr = curr.next;
        //     oneCnt--;
        // }
        // while(twoCnt > 0){
        //     curr.data = 2;
        //     curr = curr.next;
        //     twoCnt--;
        // }
        // return head;
        
        
    }
}
