import java.util.* ;
import java.io.*; 
/************************************************************

    Following is the TreeNode class structure

    class TreeNode<T>
    {
       public:
        T data;
        TreeNode<T> left;
        TreeNode<T> right;

        TreeNode(T data)
        {
            this.data = data;
            left = null;
            right = null;
        }
    };

************************************************************/
//https://www.naukri.com/code360/problems/floor-from-bst_920457?source=youtube&campaign=Striver_Tree_Videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=Striver_Tree_Videos&leftPanelTabValue=PROBLEM
public class Solution {
    static int ans = Integer.MIN_VALUE;

    private static void tmp(TreeNode<Integer> root, int X) {
        if (root == null) return;

        if (root.data == X) {
            ans = root.data;
            return;
        }

        if (root.data < X) {
            ans = Math.max(ans, root.data);
            tmp(root.right, X);
        } else {
            tmp(root.left, X);
        }
    }

    public static int floorInBST(TreeNode<Integer> root, int X) {
        ans = Integer.MIN_VALUE;
        tmp(root, X);
        return ans == Integer.MIN_VALUE ? -1 : ans;
    }
}
