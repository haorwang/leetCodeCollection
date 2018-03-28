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

    public void recoverTree(TreeNode root) {
        TreeNode[] nodes = new TreeNode[3];
        // 0: first, 1: second, 2: prev
        iot(root, nodes);
        int cup = nodes[0].val;
        nodes[0].val = nodes[1].val;
        nodes[1].val = cup;
    }

    public void iot(TreeNode curr, TreeNode[] nodes) {
        if (curr == null) {
            return;
        }

        iot(curr.left, nodes);

        if (nodes[2] != null && nodes[2].val > curr.val) {
            if (nodes[0] == null) {
                nodes[0] = nodes[2];
                nodes[1] = curr;
            } else {
                nodes[1] = curr;
            }
        }
        //System.out.println("prev: " + ((prev!=null)?prev.val:-1) + " curr: " + curr.val);
        nodes[2] = curr;
        iot(curr.right, nodes);
    }
}