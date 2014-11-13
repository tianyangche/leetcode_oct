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
    private TreeNode lastVisited = new TreeNode(Integer.MIN_VALUE);
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!isValidBST(root.left)) {
            return false;
        }
        if (lastVisited.val >= root.val) {
            return false;
        }
        lastVisited = root;
        if (!isValidBST(root.right)) {
            return false;
        }
        return true;
    }

}