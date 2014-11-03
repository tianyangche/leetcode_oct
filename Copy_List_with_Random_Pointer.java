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
            return null;
        }
        
        RandomListNode curr = head;
        while (curr != null) {
            RandomListNode item = new RandomListNode(curr.label);
            item.next = curr.next;
            curr.next = item;
            curr = curr.next.next;
        }
        curr = head;
        while (curr != null) {
            if (curr.random != null) {
                curr.next.random = curr.random.next;
            }
            curr = curr.next.next;
        }
        
        RandomListNode dummy = new RandomListNode(head.label - 1);
        RandomListNode res = dummy;
        curr = head;
        while (curr != null) {
            res.next = curr.next;
            curr.next = res.next.next;
            curr = curr.next;
            res = res.next;
        }
        
        return dummy.next;
    }
}