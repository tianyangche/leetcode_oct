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
    
    class ListNodeComparator implements Comparator<ListNode>{
        public int compare(ListNode node1, ListNode node2) {
            return node1.val - node2.val;
        }
    }
    private ListNodeComparator comparator = null;
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.isEmpty()) {
            return null;
        }
        
        comparator = new ListNodeComparator();
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>(lists.size(), comparator);
        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;
        for (ListNode list : lists) {
            if (list != null) {
                heap.offer(list);
            }
        }
        ListNode curr = heap.peek();
        while (curr != null) {
            head.next = curr;
            heap.poll();
            if (curr.next != null) {
                heap.offer(curr.next);
            }
            curr = heap.peek();
            head = head.next;
        }
        return dummy.next;
    }
}