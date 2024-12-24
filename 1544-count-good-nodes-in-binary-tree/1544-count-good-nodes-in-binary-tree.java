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
    void temp(TreeNode root,int maxi,int[] cnt){
        if(root == null)return;
        if(root.val >= maxi)cnt[0]++;
        temp(root.left,Math.max(root.val,maxi),cnt);
        temp(root.right,Math.max(root.val,maxi),cnt);
    }
    public int goodNodes(TreeNode root) {
        int[] cnt = {0};
        temp(root,root.val,cnt);
        return cnt[0];
        
    }
}