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
    class Pair {
        TreeNode node;
        int value;

        Pair(TreeNode node, int value) {
            this.node = node;
            this.value = value;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Deque<Pair> dq = new ArrayDeque<>();
        int ans = 0;
        if(root == null)return 0;
        dq.add(new Pair(root,0));
        while(!dq.isEmpty()){
            int max = (dq.getLast().value - dq.getFirst().value + 1);
            ans = Math.max(max,ans);
            int size = dq.size();
            for(int i = 0;i<size;i++){
                Pair curr = dq.poll();
                if(curr.node.left != null)
                    dq.offer(new Pair(curr.node.left,curr.value * 2 + 1));
                if(curr.node.right != null)
                    dq.offer(new Pair(curr.node.right,curr.value * 2 + 2));
                
            }
        }
        return ans;
    }
}