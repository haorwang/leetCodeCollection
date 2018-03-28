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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(res, new ArrayList<Integer>(), root, 0, sum);
        return res;
    }

    public void dfs(List<List<Integer>> res, List<Integer> list, TreeNode curr, int sum, int target) {
        sum += curr.val;
        list.add(curr.val);
        if (curr.left == null && curr.right == null) {
            if (sum == target) {
                res.add(new ArrayList<Integer>(list));
            }
        } else if (curr.left == null) {
            dfs(res, list, curr.right, sum, target);
        } else if (curr.right == null) {
            dfs(res, list, curr.left, sum, target);
        } else {
            dfs(res, list, curr.left, sum, target);
            dfs(res, list, curr.right, sum, target);
        }
        list.remove(list.size() - 1);

    }
}