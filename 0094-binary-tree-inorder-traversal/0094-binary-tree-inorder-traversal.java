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
    public static void in(TreeNode root,List<Integer> arr){
        if (root == null){
            return;
        }
        in(root.left,arr);
        arr.add(root.val);
        in(root.right,arr);
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        TreeNode temp = root;
        Stack<TreeNode> s = new Stack();
        while(true){
            if(temp != null){
                s.push(temp);
                temp = temp.left;
            }
            else{
                if(s.isEmpty()) break;
                temp = s.pop();
                arr.add(temp.val);
                temp = temp.right;
            }

        }
        return arr;
        
    }
}