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
    TreeNode tmp(int[] preOrder,int b,int[] i){
        if(i[0] >= preOrder.length || preOrder[i[0]] > b)return null;
        TreeNode node = new TreeNode(preOrder[i[0]++]);
        node.left = tmp(preOrder,node.val,i);
        node.right = tmp(preOrder,b,i);
        return node;
    }
    public TreeNode bstFromPreorder(int[] preorder) {
        int[] i = {0};
        return tmp(preorder,Integer.MAX_VALUE,i);
    }
}