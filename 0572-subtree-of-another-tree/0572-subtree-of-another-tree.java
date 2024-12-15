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
    public void temp(TreeNode r, TreeNode s,boolean[] ans){
        if(r == null)return;
        if(!ans[1] && r.val == s.val){
            ans[0] = true;
            tmp(r,s,ans);
            if(ans[0] == true)ans[1] = true;
        }
        temp(r.left,s,ans);
        temp(r.right,s,ans);

    }
    public void tmp(TreeNode p, TreeNode q,boolean[] ans){
        if(p == null && q == null){
            return;
        }
        if(p == null && q != null){
            ans[0] = false;
            return;
        }
        if(p != null && q == null){
            ans[0] = false;
            return;
        }
        if(p.val != q.val)ans[0] = false;

        tmp(p.left,q.left,ans);
        tmp(p.right,q.right,ans);
    }
    public boolean isSubtree(TreeNode r, TreeNode s) {
        boolean[] ans = {true,false};
        temp(r,s,ans);
        return ans[1];


    }
}