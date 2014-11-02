public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(0);
        
        for (int i = 1; i <= n; i++) {
            for (int j = res.size() - 1; j >= 0; j--) {
                res.add(res.get(j) + (1 << (i - 1)));
            }
        }
        
        return res;
    }
}