/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
		ListNode dummyHead = new ListNode (0);
		ListNode curr = head;
		while (curr != null) {
			ListNode currNext = curr.next;
			ListNode finderPrev = dummyHead;
			while (finderPrev.next != null && finderPrev.next.val < curr.val) {
				finderPrev = finderPrev.next;
			}
			ListNode finderPrevNext = finderPrev.next;
			finderPrev.next = curr;
			curr.next = finderPrevNext;
			curr = currNext;
		}
		return dummyHead.next;
	}	
}
