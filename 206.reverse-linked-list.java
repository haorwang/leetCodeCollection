/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode headNext = head.next;
        ListNode newHead = reverseList(headNext);
        head.next = null;
        headNext.next = head;
        return newHead;
    }
}
