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
    public boolean isBalanced(TreeNode root) {
        if (dfs(root) == -1) {
            return false;
        }
        return true;
    }

    public int dfs(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int left = dfs(node.left);
        int right = dfs(node.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return - 1;
        }
        return Math.max(left, right) + 1;
    }

}