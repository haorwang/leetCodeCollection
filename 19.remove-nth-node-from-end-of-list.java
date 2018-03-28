/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        ListNode curr1 = head;
        dummy.next = head;
        for (int i = 0; i <n; i++) {
        	curr1 = curr1.next;
        }
        ListNode curr2 = dummy;
        while (curr1!=null){
        	curr1 = curr1.next;
        	curr2 = curr2.next;
        }
        curr2.next = curr2.next.next;
        return dummy.next;
    }
}