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
    public boolean isValidBST(TreeNode root) {
        long[] last = new long[1];
        last[0] = Long.MIN_VALUE;
        return iot(root, last);
    }
    public boolean iot(TreeNode node, long[] last) {
        if (node == null) {
            return true;
        }

        boolean res = true;
        res = res && iot(node.left, last);
        if (node.val <= last[0]) {
            return false;
        }
        last[0] = (long) node.val;
        res = res && iot(node.right, last);
        return res;
    }
}