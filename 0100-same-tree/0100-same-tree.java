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
    public static boolean ans;
    Solution(){
        this.ans = true;
    }
    public static void temp(TreeNode p,TreeNode q){
        if(p == null && q == null){
            return;
        }
        if(p == null && q != null){
            ans = false;
            return;
        }
        if(q == null && p != null){
            ans = false;
            return;
        }

        if(p.val != q.val){
            ans = false;
            return;
        }
        temp(p.left,q.left);
        temp(p.right,q.right);
    }
    public boolean isSameTree(TreeNode p, TreeNode q) {
        temp(p,q);
        return ans;
        
    }
}