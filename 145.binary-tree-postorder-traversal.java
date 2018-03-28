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
    public List<Integer> postorderTraversal(TreeNode root) {

        List<Integer> res = new ArrayList<> ();

        if (root == null) {
            return res;
        }

        Deque<TreeNode> st = new LinkedList<>();
        Deque<Integer> stateSt = new LinkedList<>();
	
	st.push(root);
	stateSt.push(1);

	while (!st.isEmpty()) {
	    TreeNode tempNode = st.pop();
	    int state = stateSt.pop(); 
	    
	    if (state == 1) {
		st.push(tempNode);
		stateSt.push(2);
		if (tempNode.right != null) {
		    st.push(tempNode.right);
		    stateSt.push(1);
		}
		if (tempNode.left != null) {
		    st.push(tempNode.left);
		    stateSt.push(1);
		}
	    }

	    if (state == 2) {
		res.add(tempNode.val);
	    }
	}
	return res;
    }
}

