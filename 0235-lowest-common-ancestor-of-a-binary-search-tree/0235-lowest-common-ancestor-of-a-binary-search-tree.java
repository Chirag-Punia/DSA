/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {
    public TreeNode ans;
    Solution(){
        ans = null;
    }
    public void s(TreeNode r,TreeNode p,TreeNode q){
        if(r == null) return;
        if(p.val < r.val && q.val < r.val){
            s(r.left,p,q);
        }
        else if(p.val > r.val && q.val > r.val){
            s(r.right,p,q);
        }
        else{
            ans = r;
        }
    }
        
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        s(root,p,q);
        return ans;
    }   
}