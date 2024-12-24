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
    TreeNode ans;
    void temp(TreeNode root, TreeNode p, TreeNode q){
        if(root == null)return;
        if(ans == null){
            if(root.val >= p.val && root.val <= q.val){ans = root;return;}
            else if(root.val <= p.val && root.val >= q.val){ans = root;return;}
            else if(root.val > p.val && root.val > q.val)
                temp(root.left,p,q);
            else
                temp(root.right,p,q);
        }
    }
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        ans = null;
        temp(root,p,q);
        return ans;
    }
}