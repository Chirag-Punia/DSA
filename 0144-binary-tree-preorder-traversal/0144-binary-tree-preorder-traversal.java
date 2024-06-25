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
    public static void pre(TreeNode root,List<Integer> arr){
        if (root == null){
            return;
        }
        arr.add(root.val);
        pre(root.left,arr);
        pre(root.right,arr);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        Stack<TreeNode> s = new Stack();
        if(root == null){
            return arr;
        }
        s.push(root);
        while(!s.isEmpty()){
            TreeNode temp = s.pop();
            arr.add(temp.val);
            if(temp.right != null){
                s.push(temp.right);
            }
            if(temp.left != null){
                s.push(temp.left);
            }

        }
        return arr;

    }
}