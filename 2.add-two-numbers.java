/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        ListNode dummy = new ListNode(0);
        ListNode prev = dummy;
        while(curr1!=null || curr2!=null){
        	int sum = carry;
        	if(curr1!=null){
        		sum += curr1.val;
        		curr1 = curr1.next;
        	}
        	if(curr2!=null){ 
        		sum += curr2.val;
        		curr2 = curr2.next;
        	}
        	carry = sum/10;
        	prev.next = new ListNode(sum%10);
        	prev = prev.next;
        }
        if(carry==1){
        	prev.next = new ListNode(1);
        }
        return dummy.next;
    }
}