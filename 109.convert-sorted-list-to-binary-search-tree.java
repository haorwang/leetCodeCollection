/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
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
    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;

        int cnt = 0;
        while (fast.next!= null) {
            if (cnt % 2 == 1) {
                prev = slow;
                slow = slow.next;
            }
            fast = fast.next;
            cnt++;
        }

        TreeNode newNode = new TreeNode(slow.val);

        if (prev != null) {
            prev.next = null;
            newNode.left = sortedListToBST(head);
        }
        newNode.right = sortedListToBST(slow.next);
        return newNode;
    }
}