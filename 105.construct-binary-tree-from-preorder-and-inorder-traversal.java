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

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] ind = new int[1];
        return dfs(preorder, ind, inorder, 0, inorder.length);
    }

    public TreeNode dfs(int[] preOrder, int[] ind, int[] inOrder, int s, int e) {
        if (s == e) {
            return null;
        }
        TreeNode newNode = null;
        for (int i = s; i < e; i++) {
            if (inOrder[i] == preOrder[ind[0]]) {
                newNode = new TreeNode(inOrder[i]);
                ind[0]++;
                newNode.left = dfs(preOrder, ind, inOrder, s, i);
                newNode.right = dfs(preOrder, ind, inOrder, i + 1, e);
                break;
            }
        }
        return newNode;
    }
}