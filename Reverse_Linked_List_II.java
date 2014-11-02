/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;

        int count = 1;
        while (count < m) {
            count++;
            prev = prev.next;
        }
        
        ListNode curr = prev.next;
        ListNode next = null;
        while (count < n) {
            next = curr.next;
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            count++;
        }
        
        return dummy.next;
    }
}