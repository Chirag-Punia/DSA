//{ Driver Code Starts
// Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class Node {
    int data;
    Node right;
    Node left;

    Node(int val) {
        data = val;
        right = null;
        left = null;
    }
}

class GFG {

    public static Node insert(Node tree, int val) {
        Node temp = null;
        if (tree == null) {
            return new Node(val);
        }

        if (val < tree.data) {
            tree.left = insert(tree.left, val);
        } else if (val > tree.data) {
            tree.right = insert(tree.right, val);
        }

        return tree;
    }

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T-- > 0) {
            Node root = null;
            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                int k = sc.nextInt();
                root = insert(root, k);
            }

            int s = sc.nextInt();

            Solution obj = new Solution();
            int ans = obj.floor(root, s);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public static int a;
    Solution(){
        a = Integer.MIN_VALUE;
    }
    public static int s(Node r,int k){
        if(r == null) return a;
        if(r.data <= k) a = Math.max(a,r.data);
        if(r.data > k) return s(r.left,k);
        else return s(r.right,k);
    }
    public static int floor(Node root, int x) {
        // Code here
        if (root == null) return -1;
        a = Integer.MIN_VALUE;
        s(root,x);
        if(a == Integer.MIN_VALUE) return -1;
        return a;
    }
}