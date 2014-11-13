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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder.length == 0) {
            return null;
        }
        return helper(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }
    
    private TreeNode helper(int[] inorder, int a, int b, int[] postorder, int c, int d) {
        if (a > b) {
            return null;
        }
        
        int index = -1;
        
        for (int i = a; i <= b; i ++) {
            if (inorder[i] == postorder[d]) {
                index = i;
                break;
            }
        }
        
        TreeNode root = new TreeNode(postorder[d]);
        root.left = helper(inorder, a, index - 1, postorder, c, c + index - a - 1 );
        root.right = helper(inorder, index + 1, b, postorder, c + index - a, d - 1);
        
        return root;
        
    }
    
}