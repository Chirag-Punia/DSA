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
    public static TreeNode s(TreeNode root,int val){
        if(root == null || root.val == val) return root;
        else if(val > root.val) return s(root.right,val);
        else return s(root.left,val);
    }
    public TreeNode searchBST(TreeNode root, int val) {
        return s(root,val);
    }
}