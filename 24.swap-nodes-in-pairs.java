/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = head;
        while (prev.next!=null && prev.next.next!=null) {
        	ListNode curr = prev.next;
        	ListNode next = curr.next;
        	ListNode nextNext = next.next;
        	prev.next = next;
        	next.next = curr;
        	curr.next =nextNext;
        	prev = curr;
        }
        return dummy.next;
    }
}
