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
    public int tmp(TreeNode root){
        if(root == null)return 0;
        int l = tmp(root.left);
        int r = tmp(root.right);
        return 1 + Math.max(l,r);

    }
    public int maxDepth(TreeNode root) {
        return tmp(root);
    }
}