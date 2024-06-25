/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {

    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        q.add(null);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        while (!q.isEmpty()) {
            TreeNode c = q.remove();
            if (c == null) {

                ans.add(temp);
                temp = new ArrayList<>();
                if(q.isEmpty()){
                    break;
                }
                q.add(null);

            } else {
                temp.add(c.val);
                if (c.left != null) {
                    q.add(c.left);
                }
                if (c.right != null) {
                    q.add(c.right);
                }

            }
        }
        return ans;
    }
}