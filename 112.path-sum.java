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
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        return dfs(root, 0, sum);
    }

    public boolean dfs(TreeNode curr, int sum, int target) {
        sum += curr.val;

        if (curr.left == null && curr.right == null) {
            if (sum == target) {
                return true;
            } else {
                return false;
            }
        } else if (curr.left == null) {
            return dfs(curr.right, sum, target);
        } else if (curr.right == null) {
            return dfs(curr.left, sum, target);
        } else {
            return dfs(curr.right, sum, target) || dfs(curr.left, sum, target);
        }
    }
}
