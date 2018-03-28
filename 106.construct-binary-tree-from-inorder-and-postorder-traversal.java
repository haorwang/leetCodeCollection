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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        int[] ind = new int[1];
        ind[0] = inorder.length - 1;
        return dfs(inorder,0, postorder.length, postorder, ind);
    }

    public TreeNode dfs(int[] inOrder, int s, int e, int[] postOrder, int[] ind) {
        if (s == e) {
            return null;
        }
        TreeNode newNode = null;
        for (int i = 0; i < inOrder.length; i++) {
            if (inOrder[i] == postOrder[ind[0]]) {
                ind[0]--;
                newNode = new TreeNode(inOrder[i]);
                newNode.right = dfs(inOrder, i + 1, e, postOrder, ind);
                newNode.left = dfs(inOrder, s, i, postOrder, ind);
                break;
            }
        }
        return newNode;
    }
}