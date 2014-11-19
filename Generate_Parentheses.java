public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        if (n == 0) {
            return res;
        }
        String curr = "";
        helper(res, curr, n, 0, 0);
        return res;
    }
    
    private void helper(List<String> res, String curr, int n, int left, int right) {
        if (left == n && right == n) {
            res.add(curr);
        }
        if (right > left || left > n || right > n) {
            return;
        }
        helper(res, curr + "(", n, left + 1, right);
        helper(res, curr + ")", n, left, right + 1);
    }
}