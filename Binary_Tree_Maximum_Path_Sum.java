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
    private int max;
    public int maxPathSum(TreeNode root) {
        max = Integer.MIN_VALUE;
        helper(root);
        return max;
    }
    
    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int curr = root.val;
        if (left > 0) {
            curr += left;
        }
        if (right > 0) {
            curr += right;
        }
        max = Math.max(curr, max);
        return Math.max(left, right) > 0 ? Math.max(left, right) + root.val : root.val;
    }

}