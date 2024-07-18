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
    int ans = 0, d = 0;
    public int countPairs(TreeNode root, int distance) {
        d = distance;
        dist(root);
        return ans;
    }

    private int[] dist(TreeNode root){
        if (root == null) return new int[]{};
        int[] l = dist(root.left);
        int[] r = dist(root.right);
        int n = l.length, m = r.length;
        for (int i = 0; i < n; i++){
            for (int j = 0; j < m; j++)
                if (l[i] + r[j] <= d)
                    ans++;
        }

        int[] res = new int[Math.max(n + m, 1)];
        int i = 0;
        for (int k : l) res[i++] = k + 1;
        for (int k : r) res[i++] = k + 1;
        if (n + m == 0) res[0] = 1;

        return res;
    }
}