/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return ;
        }
        
        ListNode fast = head.next;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = slow;
        slow = slow.next;
        fast.next = null;
        slow = reverse(slow);
        merge(head, slow);
    }
    
    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode curr = head;
        ListNode next = curr.next;
        while (next != null) {
            curr.next = next.next;
            next.next = prev.next;
            prev.next = next;
            next = curr.next;
        }
        return dummy.next;
    }
    
    private ListNode merge(ListNode first, ListNode second) {
        if (first == null || second == null) {
            return first == null ? second : first;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        while (first != null && second != null) {
            head.next = first;
            first = first.next;
            head = head.next;
            
            head.next = second;
            second = second.next;
            head = head.next;
        }
        
        if (first != null) {
            head.next = first;
        }
        return dummy.next;
    }
}