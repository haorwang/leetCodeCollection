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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Deque<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        int layer = 0;
        while (!q.isEmpty()) {
            res.add(new ArrayList<Integer>());
            Deque<TreeNode> newQ = new LinkedList<>();

            while (!q.isEmpty()) {

                TreeNode curr = q.pollLast();
                res.get(res.size() - 1).add(curr.val);

                if (layer %2 ==0) {
                    if (curr.left != null) {
                        newQ.addLast(curr.left);
                    }
                    if (curr.right != null) {
                        newQ.addLast(curr.right);
                    }
                } else {
                    if (curr.right != null) {
                        newQ.addLast(curr.right);
                    }
                    if (curr.left != null) {
                        newQ.addLast(curr.left);
                    }
                }
            }

            layer++;
            q = newQ;
        }
        return res;
    }
}