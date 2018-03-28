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
    public int sumNumbers(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return dfs(root, 0);
    }

    public int dfs(TreeNode node, int parent) {
        if (node.left == null && node.right == null) {
            return parent + node.val;
        } else if (node.left == null) {
            return dfs(node.right, (parent + node.val) * 10);
        } else if (node.right == null) {
            return dfs(node.left, (parent + node.val) * 10);
        } else {
            return dfs(node.right, (parent + node.val) * 10)
                    + dfs(node.left, (parent + node.val) * 10);
        }
    }
}