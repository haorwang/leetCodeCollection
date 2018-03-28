/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = new ListNode(0);
        ListNode rightHead = new ListNode(0);

        ListNode prev1 = leftHead;
        ListNode prev2 = rightHead;

        ListNode curr = head;

        while (curr != null) {
            if (curr.val < x) {
                prev1.next = curr;
                prev1 = curr;
            } else {
                prev2.next = curr;
                prev2 = curr;
            }
            curr = curr.next;
        }

        prev1.next = rightHead.next;
        prev2.next = null;

        return leftHead.next;
    }
}