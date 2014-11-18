public class Solution {
    public ArrayList<ArrayList<Integer>> subsets(int[] S) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        if (S == null || S.length == 0) {
            return res;
        }
        ArrayList<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(S);
        helper(res, curr, S, 0);
        return res;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curr, int[] S, int pos) {
        res.add(new ArrayList<Integer>(curr));
        for (int i = pos; i < S.length; i++) {
            curr.add(S[i]);
            helper(res, curr, S, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
    

    

}