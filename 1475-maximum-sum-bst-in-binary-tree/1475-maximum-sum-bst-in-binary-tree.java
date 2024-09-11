class Solution {
    class Pair {
        int size;
        int max;
        int min;
        int sum;
        
        Pair(int size, int max, int min, int sum) {
            this.size = size;
            this.max = max;
            this.min = min;
            this.sum = sum;
        }
    }
    
    private int maxSum = 0;

    public Pair preOrder(TreeNode root) {
        if (root == null) {
            return new Pair(0, Integer.MIN_VALUE, Integer.MAX_VALUE, 0);
        }

        Pair left = preOrder(root.left);
        Pair right = preOrder(root.right);

        if (left.max < root.val && root.val < right.min) {
            int currentSum = left.sum + right.sum + root.val;
            maxSum = Math.max(maxSum, currentSum);
            return new Pair(left.size + right.size + 1, 
                            Math.max(root.val, right.max), 
                            Math.min(root.val, left.min), 
                            currentSum);
        }

        return new Pair(0, Integer.MAX_VALUE, Integer.MIN_VALUE, 0);
    }

    public int maxSumBST(TreeNode root) {
        preOrder(root);
        return maxSum;
    }
}
