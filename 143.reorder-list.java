/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        // Step 1: find halp point
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        ListNode half = slow.next;
        slow.next = null;

        //Step 2: reverse half point
        ListNode prev = null;
        while (half != null) {
            ListNode next = half.next;
            half.next = prev;
            prev = half;
            half = next;
        }

        //Step 3: stitch together two list
        ListNode curr1 = head;
        ListNode curr2 = prev;
        while (curr2 != null) {
            ListNode next1 = curr1.next;
            ListNode next2 = curr2.next;
            curr1.next = curr2;
            curr2.next = next1;
            curr1 = next1;
            curr2 = next2;
        }
    }
}
