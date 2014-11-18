public class Solution {
    public ArrayList<ArrayList<Integer>> combine(int n, int k) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        helper(res, curr, n, k, 1);
        return res;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curr, int n, int k, int pos) {
        if (curr.size() == k) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        
        if (pos > n) {
            return ;
        }
        
        for (int i = pos; i <= n; i ++) {
            curr.add(i);
            helper(res, curr, n, k, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
    

}