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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder.length == 0) {
            return null;
        }
        
        return helper(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }
    
    private TreeNode helper(int[] preorder, int a, int b, int[] inorder, int c, int d) {
        if (a > b) {
            return null;
        }
        
        int index = -1;
        
        for (int i = c; i <= d; i ++) {
            if (inorder[i] == preorder[a]) {
                index = i;
                break;
            }
        }
        
        TreeNode root = new TreeNode(preorder[a]);
        root.left = helper(preorder, a + 1, index - c + a, inorder, c, index - 1);
        root.right = helper(preorder, index - c + a + 1, b, inorder, index + 1, d);
        
        return root;
    }
}