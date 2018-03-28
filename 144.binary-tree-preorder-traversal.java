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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<TreeNode> st = new LinkedList<>();
        TreeNode curr = root;
        st.push(root);
        res.add(root.val);
        while (!st.isEmpty()) {
            while (curr.left != null) {
                curr = curr.left;
                st.push(curr);
                res.add(curr.val);
            }
            TreeNode poped = st.pop();
            if (poped.right != null) {
                curr = poped.right;
                res.add(curr.val);
                st.push(curr);
            }
        }
        return res;
    }
}


