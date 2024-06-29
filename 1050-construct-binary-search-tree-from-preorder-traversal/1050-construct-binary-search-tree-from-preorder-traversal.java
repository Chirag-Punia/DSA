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
    public static int i;
    public Solution(){
        this.i = 0;
    }
    public static TreeNode build(int[] p,int b){
        if(i >= p.length || p[i] > b) return null;
        TreeNode newNode = new TreeNode(p[i++]);
        newNode.left = build(p,newNode.val);
        newNode.right = build(p,b);
        return newNode;
    }
    public static TreeNode bstFromPreorder(int[] p) {
        return build(p,Integer.MAX_VALUE);
    }
}