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
    public ArrayList<Integer> postorderTraversal(TreeNode root) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (root == null) {
            return res;
        }
        Stack<TreeNode> stack = new Stack<TreeNode>();
        stack.push(root);
        TreeNode prev = null;
        TreeNode curr = root;
        
        while (!stack.isEmpty()) {
            curr = stack.peek();
            if (prev == null || prev.left == curr || prev.right == curr) {
                if (curr.left != null) {
                    stack.push(curr.left);
                } else if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    res.add(curr.val);
                    stack.pop();
                }
            } else if (curr.left == prev) {
                if (curr.right != null) {
                    stack.push(curr.right);
                } else {
                    res.add(curr.val);
                    stack.pop();
                }
            } else {
                res.add(curr.val);
                stack.pop();
            }
            prev = curr;
        }
        return res;
    }
}