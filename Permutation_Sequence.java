public class Solution {
    public String getPermutation(int n, int k) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int count = 1;
        for (int i = 1; i <= n; i++) {
            count *= i;
            list.add(i);
        }
        
        k--;
        StringBuffer res = new StringBuffer();
        for (int i = n; i >= 1; i--) {
            count /= i;
            int index = k / count;
            res.append(list.get(index));
            list.remove(index);
            k = k % count;
        }
        
        return res.toString();
    }
}