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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode curr = head;
        int totalNodes = 0;
        while (curr!=null) {
            totalNodes++;
            curr = curr.next;
        }

        if (totalNodes == n) {
            return head.next;
        }

        int targetIndex = totalNodes - n;
        curr = head;
        
        for (int i = 1; i < targetIndex; i++) {
            curr = curr.next;
        }

        curr.next = curr.next.next;

        return head;
    }
}