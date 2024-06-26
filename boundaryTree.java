/************************************************************

 Following is the Binary Tree node structure:

 class TreeNode {
     int data;
     TreeNode left;
     TreeNode right;

     TreeNode(int data) {
         this.data = data;
         this.left = null;
         this.right = null;
     }
 }

 ************************************************************/

import java.util.*;

public class Solution {
  //https://www.naukri.com/code360/problems/boundary-traversal_790725?leftPanelTabValue=PROBLEM
    public static boolean isLeaf(TreeNode root) {
        return root.left == null && root.right == null;
    }
     public static void left(TreeNode root, List<Integer> ans) {
        TreeNode curr = root.left;
        while (curr != null) {

            if (!isLeaf(curr)) {
                ans.add(curr.data);
            }

            if (curr.left != null) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
        }
    }
    public static void right(TreeNode root, List<Integer> ans) {
        Stack<Integer> stack = new Stack<>();
        TreeNode curr = root.right;
        while (curr != null) {
            if (!isLeaf(curr)) {
                stack.push(curr.data);
            }
            if (curr.right != null) {
                curr = curr.right;
            } else {
                curr = curr.left;
            }
        }
        while (!stack.isEmpty()) {
            ans.add(stack.pop());
        }
    }

    public static void leaf(TreeNode root,List<Integer> ans){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null) ans.add(root.data);
        else{
            leaf(root.left,ans);
            leaf(root.right,ans);
        }
        
        return;

    }
      
    public static List<Integer> traverseBoundary(TreeNode root){
        // Write your code here.
        List<Integer> ans= new ArrayList<>();
        ans.add(root.data);
        left(root,ans);
        leaf(root,ans);
        right(root,ans);

        
        return ans;
    }
}
