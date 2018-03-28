/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
    	ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
    	ListNode curr1 = l1;
        ListNode curr2 = l2;
        while (curr1 != null && curr2 != null) {
        	if (curr1.val < curr2.val) {
        		prev.next = curr1;
        		curr1 = curr1.next;
        	} else {
        		prev.next = curr2;
        		curr2 = curr2.next;
        	}
        	prev = prev.next;
        }
        if (curr1 == null) {
        	prev.next = curr2;
        } else {
        	prev.next = curr1;
        }
        return dummy.next;
    }
}

