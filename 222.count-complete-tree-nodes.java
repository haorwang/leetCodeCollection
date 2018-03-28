/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        int leftLeftHeight = leftHeight(root.left);
        int rightLeftHeight = leftHeight(root.right);
        if (leftLeftHeight == rightLeftHeight) {
            return (int) Math.pow(2, leftLeftHeight) + countNodes(root.right);
        } else {
            return countNodes(root.left) + (int) Math.pow(2, rightLeftHeight) ;
        }

    }

    public int leftHeight(TreeNode node) {
        if (node == null) {
            return  0;
        }
        return leftHeight(node.left) + 1;
    }
}
