public class Solution {
    public ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
        ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer> curr = new ArrayList<Integer>();
        Arrays.sort(num);
        helper(res, curr, num, 0);
        return res;
    }
    
    private void helper(ArrayList<ArrayList<Integer>> res, ArrayList<Integer> curr, int[] num, int pos) {
        res.add(new ArrayList<Integer>(curr));
        for (int i = pos; i < num.length; i ++) {
            if (i != pos && num[i] == num[i - 1]) {
                continue;
            }
            curr.add(num[i]);
            helper(res, curr, num, i + 1);
            curr.remove(curr.size() - 1);
        }
    }
}