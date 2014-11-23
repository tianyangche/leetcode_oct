public class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (numRows == 0) {
            return res;
        }
        List<Integer> curr = new ArrayList<Integer>();
        curr.add(1);
        res.add(new ArrayList<Integer>(curr));
        
        for (int i = 2; i <= numRows;  i++) {
            curr = new ArrayList<Integer>();
            curr.add(1);
            List<Integer> prev = res.get(res.size() - 1);
            for (int j = 1; j <= i - 2; j++) {
                int element = prev.get(j - 1) + prev.get(j);
                curr.add(element);
            }
            curr.add(1);
            res.add(curr);
        }
        
        return res;
    }
}