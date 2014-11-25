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
        curr.next = null;
        
        while (curr != null) {
            TreeLinkNode prev = null;
            TreeLinkNode next = null;
            while (curr != null) {
                if (next == null) {
                    next = curr.left != null ? curr.left : curr.right;
                }
                if (curr.left != null) {
                    if (prev != null) {
                        prev.next = curr.left;
                        prev = prev.next;
                    } else {
                        prev = curr.left;
                    }
                }
                if (curr.right != null) {
                    if (prev != null) {
                        prev.next = curr.right;
                        prev = prev.next;
                    } else {
                        prev = curr.right;
                    }
                }
                curr = curr.next;
            }
            curr = next;
        }
    }
}