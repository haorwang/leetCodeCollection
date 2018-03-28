/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode sortList(ListNode head) {
    	
		if (head == null || head.next == null) {
			return head;	
		}
		
		ListNode fast = head;
		ListNode slow = head;

		while (fast != null && fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;	
		}
		//break one list into two half
		ListNode secondHead = slow.next;
		slow.next = null;
		
		//recusive solve
		head = sortList(head);
		secondHead = sortList(secondHead);
		
		//merge two sorted array
		ListNode dummyHead = new ListNode(0);
		ListNode prev = dummyHead;
		ListNode curr1 = head;
		ListNode curr2 = secondHead;

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
		if (curr1 != null) {
			prev.next = curr1;	
		} else {
			prev.next = curr2;	
		}

		return dummyHead.next ;
    }
}


