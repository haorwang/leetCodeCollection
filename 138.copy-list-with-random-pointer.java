/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class Solution {
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return head;
        }
        RandomListNode curr = head;

        while (curr != null) {
            RandomListNode next = curr.next;
            curr.next = new RandomListNode(curr.label);
            curr.next.next = next;
            curr = next;
        }

        curr = head;

        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }

        curr = head;
        RandomListNode newHead = curr.next;

        while (curr != null) {
            RandomListNode next = curr.next.next;
            if (next != null) {
                curr.next.next = next.next;
            }
            curr.next = next;
            curr = next;
        }

        return newHead;
    }
}
