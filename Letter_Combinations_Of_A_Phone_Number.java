public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        String[] keyboard = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(digits, keyboard, res, "", 0);
        return res;
    }

    private void helper(String digits, String[] keyboard, List<String> res, String curr, int pos) {
        if (pos == digits.length()) {
            res.add(curr);
            return;
        }
        
        String button = keyboard[digits.charAt(pos) - '0'];
        if (button.equals("")) {
            helper(digits, keyboard, res, curr, pos + 1);
        } else {
            for (int i = 0; i < button.length(); i++) {
                helper(digits, keyboard, res, curr + button.charAt(i), pos + 1);
            }
        }
    }
    
    

}