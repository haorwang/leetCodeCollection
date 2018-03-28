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


    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        TreeNode rootRight = root.right;
        if (root.left != null) {
            TreeNode curr = root.left;
            while (curr.right != null) {
                curr = curr.right;
            }
            curr.right = rootRight;
            root.right = root.left;
            root.left = null;
        }
        flatten (root.right);
    }

}