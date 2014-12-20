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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int m = 1;
        int n = 1;
        ListNode temp = headA;
        while (temp.next != null) {
            m++;
            temp = temp.next;
        }
        
        temp = headB;
        while (temp.next != null) {
            n++;
            temp = temp.next;
        }
        
        ListNode a = headA;
        ListNode b = headB;
        while (m > n) {
            a = a.next;
            m--;
        }
        while (n > m) {
            b = b.next;
            n--;
        }
        
        while (a != null && a.val != b.val) {
            if (a.val != b.val) {
                a = a.next;
                b = b.next;
            } else {
                return a;
            }
        }
        return a;
    }
}