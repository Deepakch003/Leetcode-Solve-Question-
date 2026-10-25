/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
      if (head == null || head.next == null || k == 0) {
            return head;
        }

        ListNode temp = head;
        int sz = 0;

        while (temp != null) {
            sz++;
            temp = temp.next;
        }

        k = k % sz;

        if (k == 0) {
            return head;
        }

        temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = head;

        int steps = sz - k;
        ListNode node = head;

        for (int i = 1; i < steps; i++) {
            node = node.next;
        }

        head = node.next;
        node.next = null;

        return head;
        
    }
}