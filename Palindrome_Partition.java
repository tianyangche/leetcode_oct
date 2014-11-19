public class Solution {
    public ArrayList<ArrayList<String>> partition(String s) {
        ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();
        if (s == null || s.isEmpty()) {
            return res;
        }
        ArrayList<String> curr = new ArrayList<String>();
        boolean[][] flag = isPalindrome(s);
        
        helper(res, curr, s, flag, 0);
        return res;
    }
    
    private void helper(ArrayList<ArrayList<String>> res, ArrayList<String> curr, String s, boolean[][] flag, int pos) {
        if (pos == s.length()) {
            res.add(new ArrayList<String>(curr));
            return;
        }
        for (int i = 0; pos + i < s.length(); i++) {
            if (!flag[pos][pos + i]) {
                continue;
            }
            String first = s.substring(pos, pos + i + 1);
            curr.add(first);
            helper(res, curr, s, flag, pos + i + 1);
            curr.remove(curr.size() - 1);
        }
    }
    
    private boolean[][] isPalindrome(String str) {
        int n = str.length();
        boolean[][] flag = new boolean[n][n];
        for (boolean[] row : flag) {
            Arrays.fill(row, false);
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0; j--) {
                if ( i == j || ((i - j == 1) && str.charAt(i) == str.charAt(j)) || (str.charAt(i) == str.charAt(j) && flag[j + 1][i - 1])) {
                    flag[j][i] = true;
                } else {
                    flag[j][i] = false;
                }
            }
        }
        return flag;
    }
}