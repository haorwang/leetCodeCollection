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
    public TreeNode sortedArrayToBST(int[] nums) {
        return dfs(nums, 0, nums.length);
    }

    public TreeNode dfs(int[] nums, int s, int e) {
        if (s == e) {
            return null;
        }
        int mid = (s + e) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = dfs(nums, s, mid);
        node.right = dfs(nums, mid + 1, e);
        return node;
    }
}