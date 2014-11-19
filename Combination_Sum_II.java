public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (candidates == null || candidates.length == 0) {
            return res;
        }
        List<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(res, curr, candidates, target, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> curr, int[] candidates, int target, int pos) {
        if (target == 0) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        if (pos == candidates.length) {
            return;
        }
        for (int i = pos; i < candidates.length; i++) {
            if (target < candidates[i]) {
                return;
            }
            if (i != pos && candidates[i] == candidates[i - 1]) {
                continue;
            }
            curr.add(candidates[i]);
            helper(res, curr, candidates, target - candidates[i], i + 1);
            curr.remove(curr.size() - 1);
        }
    }

}