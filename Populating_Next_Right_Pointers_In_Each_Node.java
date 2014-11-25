/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        TreeLinkNode curr = root;
        root.next = null;
        
        while (curr.left != null) {
            TreeLinkNode temp = curr;
            while (curr != null) {
                curr.left.next = curr.right;
                curr.right.next = curr.next != null ? curr.next.left : null;
                curr = curr.next;
            }
            curr = temp.left;
        }
    }
}