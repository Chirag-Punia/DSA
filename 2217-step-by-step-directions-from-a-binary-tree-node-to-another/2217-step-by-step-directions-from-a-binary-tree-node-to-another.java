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
    
    public TreeNode lowestCommonAncestor(TreeNode root, int src, int dest) {
        if (root == null) {
            return null;
        }
        
        if (root.val == src || root.val == dest) {
            return root;
        }
        
        TreeNode left = lowestCommonAncestor(root.left, src, dest);
        TreeNode right = lowestCommonAncestor(root.right, src, dest);
        
        if (left != null && right != null) {
            return root;
        }
        
        return left != null ? left : right;
    }
    
    public boolean findPath(TreeNode LCA, int target, StringBuilder path) {
        if (LCA == null) {
            return false;
        }
        
        if (LCA.val == target) {
            return true;
        }
        
        // explore left
        path.append('L');
        if (findPath(LCA.left, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        // explore right
        path.append('R');
        if (findPath(LCA.right, target, path)) {
            return true;
        }
        path.deleteCharAt(path.length() - 1);
        
        return false;
    }
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        TreeNode LCA = lowestCommonAncestor(root, startValue, destValue);
        
        StringBuilder lcaToSrc = new StringBuilder();
        StringBuilder lcaToDest = new StringBuilder();
        
        findPath(LCA, startValue, lcaToSrc);
        findPath(LCA, destValue, lcaToDest);
        
        StringBuilder result = new StringBuilder();
        
        for (int i = 0; i < lcaToSrc.length(); i++) {
            result.append('U');
        }
        
        result.append(lcaToDest);
        
        return result.toString();
    }
}