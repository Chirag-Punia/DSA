/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    boolean ans;
    public boolean exist(ListNode head,TreeNode root){
        if(head == null)return true;
        if(root == null)return false;
        if(head.val != root.val)
            return false;
        boolean left = exist(head.next,root.left);
        boolean right = exist(head.next,root.right);
        return left || right;

    }
    public void inOrder(ListNode head,TreeNode root){
        if(root == null)return;
        if(exist(head,root)){
            ans = true;
            return;
        }
        inOrder(head,root.left);
        inOrder(head,root.right);
    }
    public boolean isSubPath(ListNode head, TreeNode root) {
        ans = false;
        inOrder(head,root);
        return ans;
    }
}