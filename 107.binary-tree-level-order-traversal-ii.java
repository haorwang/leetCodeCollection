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

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();

        Deque<TreeNode> q = new LinkedList<>();

        if (root != null) {
            q.offer(root);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            res.add(0, new ArrayList<Integer>());
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();
                res.get(0).add(curr.val);
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
            }
        }
        return res;
    }

}