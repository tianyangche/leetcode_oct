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
    public ArrayList<ArrayList<Integer>> pathSum(TreeNode root, int sum) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (root == null) {
            return res;
        }
        
        ArrayList<Integer> curr = new ArrayList<Integer>();
        helper(res, curr, root, sum);
        return res;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curr, TreeNode root, int sum) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                curr.add(root.val);
                res.add(new ArrayList<Integer>(curr));
                curr.remove(curr.size() - 1);
            }
            return;
        }
        
        curr.add(root.val);
        helper(res, curr, root.right, sum - root.val);
        helper(res, curr, root.left, sum - root.val);
        curr.remove(curr.size() - 1);
    }
}