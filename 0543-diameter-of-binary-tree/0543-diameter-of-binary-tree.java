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
    public static int maxi;
    Solution(){
        this.maxi = Integer.MIN_VALUE;
    }
    public static int h(TreeNode root){
        if(root == null){
            return 0;
        }
        return Math.max(h(root.left),h(root.right)) + 1;
    }
    public static int dia(TreeNode root){
        if(root == null){
            return 0;
        }
        int l = dia(root.left);
        int r = dia(root.right);
        maxi = Math.max(maxi,l+r);
        return (Math.max(l , r) + 1);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null){
            return -1;
        }
        dia(root);
        return maxi;
    }
}