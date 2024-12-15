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
    public void temp(TreeNode root){
        if(root == null)return ;

        TreeNode tem = root.left;
        root.left = root.right;
        root.right = tem;
        temp(root.left);
        temp(root.right);
    }
    public TreeNode invertTree(TreeNode root) {
        temp(root);
        return root;
    }
}