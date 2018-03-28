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
    public int maxPathSum(TreeNode root) {
        int[] max = new int[1];
        max[0] = Integer.MIN_VALUE;
        dfsLongest(root, max);
        return max[0];
    }

    public int dfsLongest(TreeNode node, int[] max) {
        if (node == null) {
            return 0;
        }
        int leftLong = dfsLongest(node.left, max);
        int rightLong = dfsLongest(node.right, max);
        max[0] = Math.max(max[0], node.val + Math.max(0, leftLong) + Math.max(0, rightLong));
        return Math.max(0, Math.max(leftLong, rightLong)) + node.val;
    }
}