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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        dfs(root, res, 0);
        return res;
    }
    public void dfs(TreeNode node, List<Integer> res, int layer) {
        if (node == null) {
            return;
        }
        if (layer == res.size()) {
            res.add(node.val);
        }
        dfs(node.right, res, layer + 1);
        dfs(node.left, res, layer + 1);
    }
}
