class Solution {
    List<Integer> arr = new ArrayList<>();

    void preOrder(TreeNode root) {
        if (root == null) return;
        arr.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    public void flatten(TreeNode root) {
        if (root == null) return;  

        arr.clear();
        preOrder(root);

        TreeNode current = root;
        for (int i = 1; i < arr.size(); i++) {
            current.left = null;  
            current.right = new TreeNode(arr.get(i));  
            current = current.right;  
        }
    }
}
