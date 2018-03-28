/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
    	if (lists.length == 0) {
    		return null;
    	}
    	if (lists.length == 1) {
    		return lists[0];
    	} 
    	if (lists.length == 2) {
    		return merge2Lists(lists[0], lists[1]);
    	}
    	
    	ListNode[] list1 = new ListNode[lists.length / 2];
    	ListNode[] list2 = new ListNode[(lists.length + 1) / 2];
    	for (int i = 0; i < list1.length; i++) {
    		list1[i] = lists[i];
    	}
    	for (int i = 0; i < list2.length; i++) {
    		list2[i] = lists[i + list1.length];
    	}
    	return merge2Lists(mergeKLists(list1), mergeKLists(list2));
    }
    public ListNode merge2Lists(ListNode l1, ListNode l2) {
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