/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        prev.next = head;
        while (prev.next != null) {
        	ListNode curr = prev.next;
        	for (int i = 0; i < k; i++) {
        		if (curr == null) {
        			return dummy.next;
        		}
        		curr = curr.next;
        	}
        	ListNode runner = prev.next;
        	ListNode runnerPrev = curr;
        	for (int i = 0; i < k; i++) {
        		ListNode runnerNext = runner.next;
        		runner.next = runnerPrev;
        		runnerPrev = runner;
        		runner = runnerNext;
        	}
        	ListNode prevNext = prev.next;
        	prev.next = runnerPrev;
        	prev = prevNext;
        }
        return dummy.next;
    }
}

