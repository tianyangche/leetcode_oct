public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            for (int j = i - 1; j >= 1 ; j--) {
                int element = res.get(j - 1) + res.get(j);
                res.set(j, element);
            }
            res.add(1);
        }
        return res;
    }
}