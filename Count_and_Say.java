public class Solution {
    public String countAndSay(int n) {
        String curr = "1";
        for (int i = 1; i < n; i++) {
            curr = nextString(curr);
        }
        return curr;
    }
    
    private String nextString(String input) {
        StringBuffer res = new StringBuffer();
        int i = 0;
        while (i < input.length()) {
            int index = i;
            while (i < input.length() && input.charAt(i) == input.charAt(index)) {
                i++;
            }
            res.append(i - index).append(input.charAt(index));
        }
        
        return res.toString();
    }
}