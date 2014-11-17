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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode res = null;
        
        ListNode original = head;
        while (original != null) {
            res = dummy;
            while (res.next != null) {
                if (res.next.val >= original.val) {
                    break;
                }
                res = res.next;
            }
            ListNode temp = original.next;
            if (res.next == null) {
                res.next = original;
                original.next = null;
            } else {
                original.next = res.next;/**
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
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        
        while (head != null) {
            ListNode curr = dummy;
            while (curr.next != null && curr.next.val < head.val) {
                curr = curr.next;
            }
            ListNode temp = head.next;
            head.next = curr.next;
            curr.next = head;
            head = temp;
        }
        return dummy.next;
    }
}
                res.next = original;
                
            }
            original = temp;
        }
        return dummy.next;
    }
}