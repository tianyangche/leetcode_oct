/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private TreeNode first = null;
    private TreeNode second = null;
    private TreeNode lastVisited = new TreeNode(Integer.MIN_VALUE);
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        helper(root);
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
    }
    
    private void helper(TreeNode root) {
        if (root == null) {
            return;
        }
        
        helper(root.left);
        if (lastVisited.val >= root.val) {
            if (first == null) {
                first = lastVisited;
            }
            second = root;
        }
        
        lastVisited = root;
        helper(root.right);
    }
}