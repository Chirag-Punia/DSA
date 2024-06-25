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
    private static boolean ans;
    public Solution() {
        this.ans = true;
    }
    public static int temp(TreeNode root){
        if (root == null){
            return 0;
        }
        int l = temp(root.left);
        int r = temp(root.right);
        if(Math.abs(l - r) > 1){
            ans = false;
        }
        return  Math.max(l,r) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        temp(root);
        return ans;
        
    }
}