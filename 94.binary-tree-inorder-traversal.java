/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode curr = root;
        Deque<TreeNode> st = new LinkedList<>();
        st.push(root);
        while (!st.isEmpty()) {
            while (curr == st.peek() && curr.left != null) {
                curr = curr.left;
                st.push(curr);
            }
            TreeNode item = st.pop();
            res.add(item.val);
            if (item.right != null) {
                curr = item.right;
                st.push(curr);
            }
        }
        return res;
    }
}