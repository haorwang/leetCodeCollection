/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        Deque<TreeLinkNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        while (!q.isEmpty()) {
            int size = q.size();
            TreeLinkNode lastNode = null;
            for (int i = 0; i < size; i++) {
                TreeLinkNode curr = q.poll();
                if (lastNode != null) {
                    lastNode.next = curr;
                }
                if (curr.left != null) {
                    q.offer(curr.left);
                }
                if (curr.right != null) {
                    q.offer(curr.right);
                }
                lastNode = curr;
            }
        }
    }
}