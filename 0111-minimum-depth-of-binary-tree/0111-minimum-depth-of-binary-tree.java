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
    int ans;
    void tmp(TreeNode root,int i){
        if(root == null)return;
        if(root.left == null && root.right == null){
            ans = Math.min(ans,i);
            return;
        }
        tmp(root.left,i+1);
        tmp(root.right,i+1);
        
    }
    public int minDepth(TreeNode root) {
        if(root == null)return 0;
        ans = Integer.MAX_VALUE;
        tmp(root,1);
        return ans;
    }
}