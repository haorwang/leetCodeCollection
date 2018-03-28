/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
        	return head;
        }
        
        int len = 0;
        for (ListNode curr = head; curr!=null; curr = curr.next) {
        	len++;
        }
        k%=len;
        
        if (k == 0) {
        	return head;
        }
        
    	ListNode fast = head;
    	ListNode slow = head;
    	for (int i = 0; i < k; i++) {
        	if (fast.next == null) {
        		return head;
        	}
    		fast = fast.next;
        }
    	
    	while (fast.next != null) {
    		slow = slow.next;
    		fast = fast.next;
    	}
    	
    	ListNode newHead = slow.next;
    	slow.next = null;
    	fast.next = head;
    	return newHead;
    }
}