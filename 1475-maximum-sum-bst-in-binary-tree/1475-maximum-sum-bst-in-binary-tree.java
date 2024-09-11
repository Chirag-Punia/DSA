class Solution {
    class Pair {
        int size; // Number of nodes in the subtree
        int max;  // Maximum value in the subtree
        int min;  // Minimum value in the subtree
        int sum;  // Sum of all node values in the subtree
        
        Pair(int size, int max, int min, int sum) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.sum = sum;
        }
    }
    
    private int maxSum = 0; // Track the maximum sum of any BST found

    public Pair preOrder(TreeNode root) {
        if (root == null) {
            return new Pair(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        Pair left = preOrder(root.left);
        Pair right = preOrder(root.right);

        // Check if the current node forms a valid BST
        if (left.max < root.val && root.val < right.min) {
            int currentSum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, currentSum); // Update the maxSum if the current BST is larger
            return new Pair(left.size + right.size + 1, 
                            Math.max(root.val, right.max), 
                            Math.min(root.val, left.min), 
                            currentSum);
        }

        // If not a valid BST, return invalid indicators
        return new Pair(0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }

    public int maxSumBST(TreeNode root) {
        preOrder(root);
        return maxSum;
    }
}
