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


    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<TreeNode>();
        }
        List<TreeNode>[] res = new List[n];

        //base case
        TreeNode item = new TreeNode(1);
        List<TreeNode> list = new ArrayList<>();
        list.add(item);
        res[0] = list;

        for (int i = 1; i < n; i++) { // i: res's ind
            res[i] = new ArrayList<TreeNode>();
            for (int j  = 0; j <= i; j++) {
                if (j == 0) {
                    List<TreeNode> rightList = res[i - j - 1];
                    for (TreeNode nodeRight : rightList) {
                        TreeNode newNode = new TreeNode(j + 1);
                        newNode.right = offsetTreeNodeCopy(nodeRight, j + 1);
                        res[i].add(newNode);
                    }
                } else if (j == i) {
                    List<TreeNode> leftList = res[j - 1];
                    for (TreeNode nodeLeft : leftList) {
                        TreeNode newNode = new TreeNode(j + 1);
                        newNode.left = offsetTreeNodeCopy(nodeLeft, 0);
                        res[i].add(newNode);
                    }
                } else {
                    List<TreeNode> rightList = res[i - j - 1];
                    List<TreeNode> leftList = res[j - 1];
                    for (TreeNode nodeRight : rightList) {
                        for (TreeNode nodeLeft : leftList) {
                            TreeNode newNode = new TreeNode(j + 1);
                            newNode.left = offsetTreeNodeCopy(nodeLeft, 0);
                            newNode.right = offsetTreeNodeCopy(nodeRight, j + 1);
                            res[i].add(newNode);
                        }
                    }
                }
            }
        }
        return res[n - 1];
    }

    public TreeNode offsetTreeNodeCopy(TreeNode node, int offset) {
        if (node == null) {
            return node;
        }
        TreeNode newNode = new TreeNode(node.val + offset);
        newNode.left = offsetTreeNodeCopy(node.left, offset);
        newNode.right = offsetTreeNodeCopy(node.right, offset);
        return newNode;
    }

}